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

public class PretraziClanove extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        String ime = request.getParameter("ime");
        String prezime = request.getParameter("prezime");
        int godinaUpisa = 0;
        try {
             godinaUpisa = Integer.parseInt(request.getParameter("godinaUpisa"));
        }catch (NumberFormatException e) {
            godinaUpisa = 0;
        }
        
        String odsek = request.getParameter("odsek");
        String kompanija = request.getParameter("kompanija");
        
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        ArrayList<Korisnik> listaKorisnika = new ArrayList<>();
        try {
            conn = DB.getInstanca().getConnection();
            st = conn.createStatement();
            String sql = "SELECT * FROM korisnik, alumni WHERE korisnik.id_korisnika = alumni.id_korisnika AND alumni.active = 1 AND korisnik.tip = 2 AND ( "
                    + "korisnik.ime = '" + ime + "' OR korisnik.prezime = '" + prezime + "' OR korisnik.godina_upisa = " + godinaUpisa + " OR korisnik.odsek = '" + odsek + "' OR alumni.zaposlenje = '" + kompanija + "')";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                int idKorisnika = rs.getInt("id_korisnika");
                String imeK = rs.getString("ime");
                String prezimeK = rs.getString("prezime");
                String email = rs.getString("email");
                int godinaUpisaK = rs.getInt("godina_upisa");
                String odsekK = rs.getString("odsek");
                String kompanijaK = rs.getString("zaposlenje");
                listaKorisnika.add(new Korisnik(idKorisnika, imeK, prezimeK, email, godinaUpisaK, odsekK, kompanijaK));
            }
            
            st.close();
        } catch (SQLException ex) {
            System.err.println(ex);
        } finally {
            DB.getInstanca().putConnection(conn);
        }

        request.setAttribute("nadjeni", listaKorisnika);
        RequestDispatcher rd = request.getRequestDispatcher("rezultatPretrageKorisnika.jsp");
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
