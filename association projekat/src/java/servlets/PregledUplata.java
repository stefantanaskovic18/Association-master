package servlets;

import beans.Korisnik;
import beans.Uplatnica;
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

public class PregledUplata extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Korisnik kor = (Korisnik) request.getSession().getAttribute("korisnik");
        int id = kor.getIdKorisnika();
        
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        
        ArrayList<Uplatnica> listaUplatnica = new ArrayList<>();
        try {
            conn = DB.getInstanca().getConnection();
            st = conn.createStatement();
            String sql = "SELECT * FROM uplatnica WHERE id_korisnika = "+id+" ORDER BY datum DESC";
            rs = st.executeQuery(sql);
            while(rs.next()) {
                String svrha = rs.getString("svrha");
                String datum = rs.getString("datum");
                int kolicina = rs.getInt("kolicina");
                listaUplatnica.add(new Uplatnica(svrha, datum, kolicina));
            }
            st.close();
        }catch(SQLException ex) {
            System.err.println(ex);
        }finally {
            DB.getInstanca().putConnection(conn);
        }
        
        request.setAttribute("listaUplatnica", listaUplatnica);
        RequestDispatcher rd = request.getRequestDispatcher("prikaziUplatnice.jsp");
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
