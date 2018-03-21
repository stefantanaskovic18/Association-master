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
import javax.servlet.http.HttpSession;

public class IzlistajAktivne extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        ArrayList<Korisnik> listaAktivnih = new ArrayList<>();
        
        try {
            conn = DB.getInstanca().getConnection();
            st = conn.createStatement();
            String sql = "SELECT * FROM korisnik, alumni WHERE korisnik.id_korisnika = alumni.id_korisnika AND active = 1";
            rs = st.executeQuery(sql);
            while(rs.next()) {
                int id = rs.getInt("id_korisnika");
                String username = rs.getString("username");
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                String pol = rs.getString("pol");
                String mestoRodjenja = rs.getString("mesto_rodjenja");
                String drzavaRodjenja = rs.getString("drzava_rodjenja");
                String jmbg = rs.getString("jmbg");
                String brojTelefona = rs.getString("broj_telefona");
                String email = rs.getString("email");
                int godinaUpisa = rs.getInt("godina_upisa");
                int godinaZavrsetka = rs.getInt("godina_zavrsetka");
                int aktivan = rs.getInt("active");
                
                listaAktivnih.add(new Korisnik(id, username, ime, prezime, pol, mestoRodjenja, drzavaRodjenja, jmbg, brojTelefona, email, godinaUpisa, godinaZavrsetka, aktivan));
            }
            st.close();
            
        }catch(SQLException ex) {
            System.err.println(ex);
        }finally {
            DB.getInstanca().putConnection(conn);
        }
        
        request.setAttribute("listaAktivnih", listaAktivnih);
        RequestDispatcher rd = request.getRequestDispatcher("listaAktivnih.jsp");
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
