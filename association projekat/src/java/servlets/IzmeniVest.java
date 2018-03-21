package servlets;

import beans.Vest;
import database.DB;
import java.io.IOException;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IzmeniVest extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        Vest vest = new Vest();
        try {
            conn = DB.getInstanca().getConnection();
            st = conn.createStatement();
            String sql = "SELECT * FROM vest WHERE id_vesti = "+id;
            rs = st.executeQuery(sql);
            
            if(rs.next()) {
                String naslov = rs.getString("naslov");
                String sadrzaj = rs.getString("sadrzaj");
                vest.setId_vesti(id);
                vest.setNaslov(naslov);
                vest.setSadrzaj(sadrzaj);
            }
            request.setAttribute("izabranaVest", vest);
            st.close();
            
            
        }catch(SQLException ex) {
            System.err.println(ex);
        }finally {
            DB.getInstanca().putConnection(conn);
        }
        
        RequestDispatcher rd = request.getRequestDispatcher("izmenaVesti.jsp");
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
