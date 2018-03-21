package servlets;

import database.DB;
import java.io.IOException;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ObrisiVest extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String iD = request.getParameter("id");
        int id = Integer.parseInt(iD);
        
        Connection conn = null;
        Statement st = null;
        
        String porukaZaBrisanje = "";
        try {
            conn = DB.getInstanca().getConnection();
            st = conn.createStatement();
            String sql = "DELETE FROM vest WHERE id_vesti = "+id;
            int ok = st.executeUpdate(sql);
            if(ok == 1) {
                porukaZaBrisanje = "Uspesno ste obrisali vest";
            }else {
                porukaZaBrisanje = "Doslo je do greske prilikom brisanja vesti";
            }
            
            st.close();
        }catch(SQLException ex) {
            System.err.println(ex);
        }finally {
            DB.getInstanca().putConnection(conn);
        }
        
        request.setAttribute("porukaZaBrisanje", porukaZaBrisanje);
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
