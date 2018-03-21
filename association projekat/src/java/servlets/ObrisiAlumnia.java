package servlets;

import database.DB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ObrisiAlumnia extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        int id = Integer.parseInt(request.getParameter("id"));
        Connection conn = null;
        Statement st = null;
        String porukaBrisanjaKorisnika = "";
        try {
            conn = DB.getInstanca().getConnection();
            st = conn.createStatement();
            String sql = "DELETE FROM alumni WHERE id_korisnika = "+id;
            int ok = st.executeUpdate(sql);
            if(ok == 1) {
                String sql2 = "DELETE FROM korisnik WHERE id_korisnika = "+id;
                int ok2 = st.executeUpdate(sql2);
                if(ok2 == 1) {
                    porukaBrisanjaKorisnika = "Uspesno ste obrisali korisnika";
                }
            }
            st.close();
        }catch(SQLException ex) {
            System.err.println(ex);
        }finally {
            DB.getInstanca().getConnection();
        }
        
        request.setAttribute("porukaBrisanjaKorisnika", porukaBrisanjaKorisnika);
        RequestDispatcher rd = request.getRequestDispatcher("potvrdaBrisanja.jsp");
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
