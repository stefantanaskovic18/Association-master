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

public class PromenaSifre extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String korIme = request.getParameter("korisnickoIme");
        String staraSifra = request.getParameter("staraSifra");
        String novaSifra = request.getParameter("novaSifra");

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

       
        String porukaPromene = "";
        try {
            conn = DB.getInstanca().getConnection();
            st = conn.createStatement();
            String sql = "SELECT id_korisnika FROM korisnik WHERE username = '" + korIme + "' AND password = '"+staraSifra+"'";
            rs = st.executeQuery(sql);
            if(rs.next()) {
                String sqlPromena = "UPDATE korisnik SET password = '"+novaSifra+"' WHERE username = '"+korIme+"'";
                int ok = st.executeUpdate(sqlPromena);
                if(ok == 1) {
                    porukaPromene = "Uspesno ste promenili sifru";
                }
            }else {
                porukaPromene = "Pogresno korisnicko ime ili sifra";
            }
            st.close();
        } catch (SQLException ex) {
            System.err.println(ex);
        } finally {
            DB.getInstanca().putConnection(conn);
        }
        request.setAttribute("porukaPromene", porukaPromene);
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
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
