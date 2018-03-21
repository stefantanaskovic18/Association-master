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

public class ObrisiDogadjaj extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        int id = Integer.parseInt(request.getParameter("id"));
        Connection conn = null;
        Statement st = null;
        String porukaBrisanjaDogadjaja = "";
        try {
            conn = DB.getInstanca().getConnection();
            st = conn.createStatement();
            String sql = "DELETE FROM dogadjaj WHERE id_dogadjaja = "+id;
            int ok = st.executeUpdate(sql);
            if(ok == 1) {
                porukaBrisanjaDogadjaja = "Uspesno ste obrisali dogadjaj";
            }else {
                porukaBrisanjaDogadjaja = "Greska prilikom brisanja dogadjaja";
            }
            
        }catch(SQLException ex) {
            System.err.println(ex);
            porukaBrisanjaDogadjaja = "Greska: "+ex.getLocalizedMessage();
        }finally {
            DB.getInstanca().putConnection(conn);
        }
        
        request.setAttribute("porukaBrisanjaDogadjaja", porukaBrisanjaDogadjaja);
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
