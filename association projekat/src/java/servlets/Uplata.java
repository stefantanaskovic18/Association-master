package servlets;

import beans.Korisnik;
import database.DB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.RequestDispatcher;

public class Uplata extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        
        Korisnik kor = (Korisnik) request.getSession().getAttribute("korisnik");
        int kolicinaUplate = Integer.parseInt(request.getParameter("iznosUplate"));
        int id = kor.getIdKorisnika();
        String svrha = request.getParameter("svrha");
        String porukaUplate = "";
        int stanjeNaRacunu = kor.getRacun();
        out.println(id+", "+stanjeNaRacunu);

        try {
            conn = DB.getInstanca().getConnection();
            st = conn.createStatement();
            if (stanjeNaRacunu < kolicinaUplate) {
                porukaUplate = "Nemate dovoljno novca na racunu";
            } else {
                String sqlUplata = "INSERT INTO uplatnica (id_korisnika, svrha, datum, kolicina) VALUES (" + id + ", '" + svrha + "', NOW(), " + kolicinaUplate + ")";
                int ok = st.executeUpdate(sqlUplata);
                if (ok == 1) {

                    String sqlSmanjiRacun = "UPDATE korisnik SET racun = " + (stanjeNaRacunu - kolicinaUplate) + " WHERE id_korisnika = " + id;
                    int ok2 = st.executeUpdate(sqlSmanjiRacun);
                    if (ok2 == 1) {
                        porukaUplate = "Uspesno ste uplatili";
                    } else {
                        porukaUplate = "Greska prilikom uplate";
                    }
                } else {
                    porukaUplate = "Doslo je do greske prilikom uplate";
                }
            }
            st.close();
        } catch (SQLException ex) {
            System.err.println(ex);
        } finally {
            DB.getInstanca().putConnection(conn);
        }

        request.setAttribute("porukaUplate", porukaUplate);
        RequestDispatcher rd = request.getRequestDispatcher("uplatnica.jsp");
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
