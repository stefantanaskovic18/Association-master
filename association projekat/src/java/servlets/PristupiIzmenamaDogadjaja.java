package servlets;

import database.DB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PristupiIzmenamaDogadjaja extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int id = Integer.parseInt(request.getParameter("idDogadjaja"));
        String naslov = request.getParameter("novNaslov");
        String sadrzaj = request.getParameter("novSadrzaj");
        String mesto = request.getParameter("novoMesto");
        String novDatum = request.getParameter("novDatum");
        
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date datumOdrzavanja = null;
        try {
            datumOdrzavanja = format.parse(novDatum);
        } catch (ParseException ex) {
            Logger.getLogger(DodavanjeDogadjaja.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        java.sql.Date sqlNovoVreme = new java.sql.Date(datumOdrzavanja.getTime());
        Connection conn = null;
        Statement st = null;
        
        String porukaIzmeneDogadjaja = "";
        try {
            conn = DB.getInstanca().getConnection();
            st = conn.createStatement();
            String sql = "UPDATE dogadjaj SET naslov = '"+naslov+"', sadrzaj = '"+sadrzaj+"', mesto = '"+mesto+"', vreme_odrzavanja = '"+sqlNovoVreme+"' WHERE id_dogadjaja = "+id;
            int ok = st.executeUpdate(sql);
            if(ok == 1) {
                porukaIzmeneDogadjaja = "Uspesno ste izmenili dogadjaj";
            }else {
                porukaIzmeneDogadjaja = "Greska pri izmeni dogadjaja";
            }
        }catch(SQLException ex) {
            System.err.println(ex);
            porukaIzmeneDogadjaja = "Greska: " +ex.getLocalizedMessage();
        }finally {
            DB.getInstanca().putConnection(conn);
        }
        
        request.setAttribute("porukaIzmeneDogadjaja", porukaIzmeneDogadjaja);
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
