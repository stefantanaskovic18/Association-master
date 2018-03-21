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

public class DodavanjeKorisnika extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String ime = request.getParameter("ime");
        String prezime = request.getParameter("prezime");
        String mestoRodjenja = request.getParameter("mestoRodjenja");
        String drzavaRodjenja = request.getParameter("drzavaRodjenja");
        String jmbg = request.getParameter("jmbg");
        String pol = request.getParameter("pol");
        String brojTelefona = request.getParameter("brojTelefona");
        String email = request.getParameter("email");
        int godinaUpisa = Integer.parseInt(request.getParameter("godinaUpisa"));
        int godinaZavrsetka = Integer.parseInt(request.getParameter("godinaZavrsetka"));
        String odsek = request.getParameter("odsek");

        Connection conn = null;
        Statement st = null;
        String porukaDodavanjaKorisnika = "";

        try {
            conn = DB.getInstanca().getConnection();
            st = conn.createStatement();
            
            String sql = "INSERT INTO korisnik (username, password, ime, prezime, mesto_rodjenja, drzava_rodjenja, jmbg, broj_telefona, email, godina_upisa, godina_zavrsetka, odsek, tip, racun, pol"
                    + ") VALUES ('" + username + "', '" + password + "', '" + ime + "', '" + prezime + "', '" + mestoRodjenja + "', '" + drzavaRodjenja + "', '" + jmbg + "', '" + brojTelefona + "', '" + email + "', " + godinaUpisa + ", " + godinaZavrsetka + ", '" + odsek + "', 2, 15000, '"+pol+"')";
            int ok = st.executeUpdate(sql);
            if (ok == 1) {
                String sql2 = "INSERT INTO alumni (id_korisnika, biografija, zaposlenje, vestina, nagrade, sertifikati, volonterski_rad, private, active) VALUES ((SELECT MAX(id_korisnika) FROM korisnik), '', '', '', '', '', '', 0, 1)";
                int ok2 = st.executeUpdate(sql2);
                if (ok2 == 1) {
                    porukaDodavanjaKorisnika = "Uspesno ste dodali novog alumni korisnika";
                } else {
                    porukaDodavanjaKorisnika = "Greska prilikom dodavanja alumni korisnika";
                }
            } else {
                porukaDodavanjaKorisnika = "Greska prilikom dodavanja korisnika u bazu";
            }

            st.close();

        } catch (SQLException ex) {
            System.err.println(ex);
            porukaDodavanjaKorisnika = "Greska: " + ex.getLocalizedMessage();
        } finally {
            DB.getInstanca().putConnection(conn);
        }

        request.setAttribute("porukaDodavanjaKorisnika", porukaDodavanjaKorisnika);
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
