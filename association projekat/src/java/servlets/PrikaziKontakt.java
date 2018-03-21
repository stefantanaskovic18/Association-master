package servlets;

import beans.Kontakt;
import database.DB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrikaziKontakt extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        
        Kontakt kontakt = new Kontakt();
        try {
            conn = DB.getInstanca().getConnection();
            st = conn.createStatement();
            String sql = "SELECT * FROM kontakt";
            rs = st.executeQuery(sql);
            if(rs.next()) {
                String adresa = rs.getString("adresa");
                String brojTelefona = rs.getString("broj_telefona");
                String email = rs.getString("email");
                String ziroRacun = rs.getString("ziro_racun");
                String pib = rs.getString("pib");
                String maticniBroj = rs.getString("maticni_broj");
                
                kontakt.setAdresa(adresa);
                kontakt.setEmail(email);
                kontakt.setBrojTelefona(brojTelefona);
                kontakt.setZiroRacun(ziroRacun);
                kontakt.setPib(pib);
                kontakt.setMaticniBroj(maticniBroj);
            }
            st.close();
        }catch(SQLException ex) {
            System.err.println(ex);
        }finally {
            DB.getInstanca().putConnection(conn);
        }
        
        request.setAttribute("kontakt", kontakt);
        RequestDispatcher rd = request.getRequestDispatcher("kontakt.jsp");
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
