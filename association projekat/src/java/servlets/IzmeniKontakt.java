package servlets;

import beans.Kontakt;
import database.DB;
import java.io.IOException;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IzmeniKontakt extends HttpServlet {

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
                int id = rs.getInt("id_kontakta");
                String adresa = rs.getString("adresa");
                String brojTelefona = rs.getString("broj_telefona");
                String email = rs.getString("email");
                String ziroRacun = rs.getString("ziro_racun");
                String pib = rs.getString("pib");
                String maticniBroj = rs.getString("maticni_broj");
                
                kontakt.setIdKontakta(id);
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
        RequestDispatcher rd = request.getRequestDispatcher("izmenaKontakta.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
