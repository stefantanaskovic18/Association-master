package servlets;

import beans.Dogadjaj;
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

public class PrikaziSveDogadjaje extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        
        ArrayList<Dogadjaj> listaDogajaja = new ArrayList<>();
        
        try {
            conn = DB.getInstanca().getConnection();
            st = conn.createStatement();
            String query = "SELECT * FROM dogadjaj ORDER BY datum_postavljanja DESC";
            rs = st.executeQuery(query);
            // maksimum 3 dogadjaja, dodati brojac do 3 da broji
            int brojac = 0;
            while(rs.next()) {
                int idDogadjaja = rs.getInt("id_dogadjaja");
                String naslov = rs.getString("naslov");
                String sadrzaj = rs.getString("sadrzaj");
                String slika = rs.getString("slika");
                String datumPostavljanja = rs.getString("datum_postavljanja");
                String datumOdrzavanja = rs.getString("vreme_odrzavanja");
                String mesto = rs.getString("mesto");
                listaDogajaja.add(new Dogadjaj(idDogadjaja, naslov, sadrzaj, datumPostavljanja, slika, datumOdrzavanja, mesto));
                brojac ++;
                if(brojac==3)
                    break;
            }
            st.close();
            request.setAttribute("lista_dogadjaja", listaDogajaja);
            
            
        }catch(SQLException ex) {
            System.err.println(ex);
        }finally{
            DB.getInstanca().putConnection(conn);
        }
        
        RequestDispatcher rd = request.getRequestDispatcher("dogadjaji.jsp");
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
