package servlets;

import beans.Vest;
import database.DB;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IzlistajSveVesti extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        ArrayList<Vest> listaVesti = new ArrayList<>();
        try {
            conn = DB.getInstanca().getConnection();
            st = conn.createStatement();
            String query = "SELECT * FROM vest";
            rs = st.executeQuery(query);
            while(rs.next()) {
                int idVesti = rs.getInt("id_vesti");
                String naslov = rs.getString("naslov");
                String sadrzaj = rs.getString("sadrzaj");
                String slika = rs.getString("slika");
                String datumPostavljanja = rs.getString("datum_postavljanja");
                listaVesti.add(new Vest(idVesti, naslov, sadrzaj, datumPostavljanja, slika));
            }
            st.close();
            request.setAttribute("listaVesti", listaVesti);
            
            
        }catch(SQLException ex) {
            System.err.println(ex);
        }finally{
            DB.getInstanca().putConnection(conn);
        }
        
        RequestDispatcher rd = request.getRequestDispatcher("azurirajVest.jsp");
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
