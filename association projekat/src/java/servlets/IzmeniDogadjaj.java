package servlets;

import beans.Dogadjaj;
import database.DB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IzmeniDogadjaj extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        Dogadjaj dogadjaj = new Dogadjaj();

        try {
            conn = DB.getInstanca().getConnection();
            st = conn.createStatement();
            String sql = "SELECT * FROM dogadjaj WHERE id_dogadjaja = " + id;
            rs = st.executeQuery(sql);
            if(rs.next()) {
                String naslov = rs.getString("naslov");
                String sadrzaj = rs.getString("sadrzaj");
                String datumPostavljanja = rs.getString("datum_postavljanja");
                String slika = rs.getString("slika");
                String vremeOdrzavanja = rs.getString("vreme_odrzavanja");
                String mesto = rs.getString("mesto");
                
                dogadjaj.setId_dogadjaja(id);
                dogadjaj.setNaslov(naslov);
                dogadjaj.setSlika(slika);
                dogadjaj.setSadrzaj(sadrzaj);
                dogadjaj.setDatumOdrzavanja(vremeOdrzavanja);
                dogadjaj.setDatumPostavljanja(datumPostavljanja);
                dogadjaj.setMesto(mesto);
            }
            st.close();
        } catch (Exception ex) {
            System.err.println(ex);
        } finally {
            DB.getInstanca().putConnection(conn);
        }
        request.setAttribute("dogadjaj", dogadjaj);
        RequestDispatcher rd = request.getRequestDispatcher("izmenaDogadjaja.jsp");
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
