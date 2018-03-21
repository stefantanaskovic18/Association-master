package servlets;

import database.DB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DodavanjeDogadjaja extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String naslov = request.getParameter("naslovDogadjaja");
        String sadrzaj = request.getParameter("sadrzajDogadjaja");
        String mesto = request.getParameter("mestoDogadjaja");
        String datumDogadjaja = request.getParameter("vremeOdrzavanja");
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date datumOdrzavanja = null;
        try {
            datumOdrzavanja = format.parse(datumDogadjaja);
        } catch (ParseException ex) {
            Logger.getLogger(DodavanjeDogadjaja.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        java.sql.Date sqlVreme = new java.sql.Date(datumOdrzavanja.getTime());
        
        Connection conn = null;
        Statement st = null;
        String porukaDodavanja = "";

        try {
            conn = DB.getInstanca().getConnection();
            st = conn.createStatement();
            String sql = "INSERT INTO dogadjaj (naslov, sadrzaj, datum_postavljanja, vreme_odrzavanja, mesto) VALUES ('" + naslov + "', '" + sadrzaj + "', NOW(), '" + sqlVreme + "', '" + mesto + "')";
            
            int ok = st.executeUpdate(sql);
            if (ok == 1) {
                porukaDodavanja = "Uspesno ste dodali novi dogadjaj";
            } else {
                porukaDodavanja = "Greska pri dodavanju novog dogadjaja";
            }

            st.close();
        } catch (SQLException ex) {
            System.err.println(ex);
            porukaDodavanja = "Greska: " + ex.getLocalizedMessage();
        } finally {
            DB.getInstanca().putConnection(conn);
        }
        
        request.setAttribute("porukaDodavanja", porukaDodavanja);
        RequestDispatcher rd = request.getRequestDispatcher("dodavanjeDogadjaja.jsp");
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
