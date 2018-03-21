package servlets;

import java.io.IOException;
import database.DB;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DodavanjeVesti extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String naslov = (String)request.getParameter("naslovVesti");
        String sadrzaj = (String)request.getParameter("sadrzaj");
        
        String porukaZaVest;
        if(naslov.length() == 0) {
            porukaZaVest = "Ne valja duzina.";
            request.setAttribute("porukaZaVest", porukaZaVest);
            RequestDispatcher rd = request.getRequestDispatcher("dodajVest.jsp");
            rd.forward(request, response);
            return;
        }
        Connection conn = null;
        Statement st = null;
        try {
            
            conn = DB.getInstanca().getConnection();
            st = conn.createStatement();
            String sql = "INSERT INTO vest (naslov, sadrzaj, datum_postavljanja) VALUES ('"+naslov+"', '"+sadrzaj+"', NOW())";
            
            int ok = st.executeUpdate(sql);
            
            
            if(ok==1) {
                porukaZaVest = "Uspesno ste dodali novu vest";
            }else {
                porukaZaVest = "Doslo je do greske prilikom dodavanja vesti";
            }
           
            st.close();
           
            
        }catch(SQLException ex) {
            porukaZaVest = "Usao sam u exception: " + ex.getLocalizedMessage();
        }finally {
            DB.getInstanca().putConnection(conn);
        }
        request.setAttribute("porukaZaVest", porukaZaVest);
        RequestDispatcher rd = request.getRequestDispatcher("dodajVest.jsp");
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
