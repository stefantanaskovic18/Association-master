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

public class PristupiIzmenama extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        
        int id = Integer.parseInt(request.getParameter("idVesti"));
        String noviNaslov = request.getParameter("novNaslovi");
        String noviSadrzaj = request.getParameter("novSadrzaj");
        Connection conn = null;
        Statement st = null;
        String porukaIzmena = "";
        try {
            conn = DB.getInstanca().getConnection();
            st = conn.createStatement();
            String sql = "UPDATE vest SET naslov = '"+noviNaslov+"', sadrzaj = '"+noviSadrzaj+"' WHERE id_vesti = "+id;
            int ok = st.executeUpdate(sql);
            if(ok == 1) {
                porukaIzmena = "Uspesno ste izmenili vest";
            }else {
                porukaIzmena = "Doslo je do greske prilikom izmene vesti";
            }
            st.close();
            
        }catch(SQLException ex) {
            System.err.println(ex);
        }finally {
            DB.getInstanca().putConnection(conn);
        }
        request.setAttribute("porukaIzmena", porukaIzmena);
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
