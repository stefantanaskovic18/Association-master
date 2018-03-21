package servlets;

import beans.Korisnik;
import database.DB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PristupiIzmenamaProfila extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Korisnik kor = (Korisnik) request.getSession().getAttribute("korisnik");
        int id = kor.getIdKorisnika();

        String biografija = request.getParameter("biografija");
        String zaposlenje = request.getParameter("zaposlenje");
        String vestine = request.getParameter("vestine");
        String nagrade = request.getParameter("nagrade");
        String sertifikati = request.getParameter("sertifikati");
        String volonterskiRad = request.getParameter("volonterskiRad");
        String[] jezici = request.getParameterValues("jezici");
        int vidljivost = Integer.parseInt(request.getParameter("vidljivost"));
        
        Connection conn = null;
        Statement st = null;
        String porukaIzmeneKorisnika = "";
        try {
            conn = DB.getInstanca().getConnection();
            st = conn.createStatement();
            String sql = "UPDATE alumni SET biografija = '" + biografija + "', zaposlenje = '" + zaposlenje + "', vestina = '" + vestine + "', nagrade = '" + nagrade + "', sertifikati = '" + sertifikati + "', volonterski_rad = '" + volonterskiRad + "', private = " + vidljivost + " WHERE id_korisnika = " + id;
            int ok = st.executeUpdate(sql);
            if (ok == 1 && jezici != null) {
                String sqlDelete = "DELETE FROM jezik_korisnika WHERE id_korisnika = " + id;
                int ok2 = st.executeUpdate(sqlDelete);
                if (jezici.length != 0) {
                    for (int i = 0; i < jezici.length; i++) {
                        String sqlInsert = "INSERT INTO jezik_korisnika (id_korisnika, id_jezika) VALUES (" + id + ", " + jezici[i] + ")";
                        int ok3 = st.executeUpdate(sqlInsert);
                    }
                }
                porukaIzmeneKorisnika = "Uspesno ste izmenili profil. Odjavite se pa se ponovo prijavite da biste videli promene.";
            } else {
                porukaIzmeneKorisnika = "Uspesno ste izmenili profil. Odjavite se pa se ponovo prijavite da biste videli promene.";
            }

            st.close();
        } catch (SQLException ex) {
            System.err.println(ex);
            porukaIzmeneKorisnika = "Greska: " + ex.getLocalizedMessage();
        } finally {
            DB.getInstanca().putConnection(conn);
        }

        request.setAttribute("porukaIzmeneKorisnika", porukaIzmeneKorisnika);
        RequestDispatcher rd = request.getRequestDispatcher("potvrdeAlumni.jsp");
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
