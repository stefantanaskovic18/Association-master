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

public class PristupiIzmenamaKontakta extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String adresa = request.getParameter("adresa");
        String brojTelefona = request.getParameter("brojTelefona");
        String email = request.getParameter("email");
        String ziroRacun = request.getParameter("ziroRacun");
        String pib = request.getParameter("pib");
        String maticniBroj = request.getParameter("maticniBroj");
        
        Connection conn = null;
        Statement st = null;
        
        String porukaIzmeneKontakta = "";
        
        try {
            conn = DB.getInstanca().getConnection();
            st = conn.createStatement();
            String sql = "UPDATE kontakt SET adresa = '"+adresa+"', broj_telefona = '"+brojTelefona+"', email = '"+email+"', ziro_racun = '"+ziroRacun+"', pib = '"+pib+"', maticni_broj = '"+maticniBroj+"'";
            int ok = st.executeUpdate(sql);
            if(ok == 1) {
                porukaIzmeneKontakta = "Uspesno ste izmenili kontakt";
            }else {
                porukaIzmeneKontakta = "Doslo je do greske prilikom izmene kontakta";
            }
            
            st.close();
            
        }catch(SQLException ex) {
            System.err.println(ex);
        }finally {
            DB.getInstanca().putConnection(conn);
        }
        request.setAttribute("porukaIzmeneKontakta", porukaIzmeneKontakta);
        RequestDispatcher rd = request.getRequestDispatcher("potvrdaBrisanja.jsp");
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
