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

public class PregledUplataBlagajnik extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        ArrayList<Uplatnica> listaUplatnica = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        
        try {
            conn = DB.getInstanca().getConnection();
            st = conn.createStatement();
            String sql = "SELECT * FROM korisnik, uplatnica WHERE korisnik.id_korisnika = uplatnica.id_korisnika";
            rs = st.executeQuery(sql);
            while(rs.next()) {
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                String username = rs.getString("username");
                String svrha = rs.getString("svrha");
                String datum = rs.getString("datum");
                int kolicina = rs.getInt("kolicina");
                
                listaUplatnica.add(new Uplatnica(svrha, datum, kolicina, new Korisnik(ime, prezime, username)));
            }
            st.close();
        }catch(SQLException ex) {
            System.err.println(ex);
        }finally {
            DB.getInstanca().putConnection(conn);
        }
        request.setAttribute("listaUplatnicaBlagajnik", listaUplatnica);
        RequestDispatcher rd = request.getRequestDispatcher("izlistajUplatniceBlagajnik.jsp");
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
