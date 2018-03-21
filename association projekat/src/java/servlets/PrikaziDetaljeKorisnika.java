package servlets;

import beans.Jezik;
import beans.Korisnik;
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

public class PrikaziDetaljeKorisnika extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        int id = Integer.parseInt(request.getParameter("id"));
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        ResultSet rss = null;
        
        ArrayList<Jezik> jezici = new ArrayList<>();
        Korisnik korisnik = new Korisnik();
        try {
            conn = DB.getInstanca().getConnection();
            st = conn.createStatement();
            String sql = "SELECT * FROM korisnik, alumni WHERE korisnik.id_korisnika = alumni.id_korisnika AND korisnik.id_korisnika = " + id + " AND alumni.active = 1";
            rs = st.executeQuery(sql);
            if (rs.next()) {
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                String pol = rs.getString("pol");
                String mestoRodjenja = rs.getString("mesto_rodjenja");
                String drzavaRodjenja = rs.getString("drzava_rodjenja");
                String jmbg = rs.getString("jmbg");
                String brojTelefona = rs.getString("broj_telefona");
                String email = rs.getString("email");
                int godinaUpisa = rs.getInt("godina_upisa");
                int godinaZavrsetka = rs.getInt("godina_zavrsetka");
                String odsek = rs.getString("odsek");
                String biografija = rs.getString("biografija");
                String zaposlenje = rs.getString("zaposlenje");
                String vestina = rs.getString("vestina");
                String nagrade = rs.getString("nagrade");
                String sertifikati = rs.getString("sertifikati");
                String volonterskiRad = rs.getString("volonterski_rad");

                korisnik.setIme(ime);
                korisnik.setPrezime(prezime);
                korisnik.setPol(pol);
                korisnik.setMestoRodjenja(mestoRodjenja);
                korisnik.setDrzavaRodjenja(drzavaRodjenja);
                korisnik.setBrojTelefona(brojTelefona);
                korisnik.setJmbg(jmbg);
                korisnik.setEmail(email);
                korisnik.setGodinaUpisa(godinaUpisa);
                korisnik.setGodinaZavrsetka(godinaZavrsetka);
                korisnik.setOdsek(odsek);
                korisnik.setBiografija(biografija);
                korisnik.setZaposlenje(zaposlenje);
                korisnik.setVestina(vestina);
                korisnik.setNagrade(nagrade);
                korisnik.setSertifikati(sertifikati);
                korisnik.setVolonterskiRad(volonterskiRad);
            }
            String sql2 = "SELECT ime_jezika FROM jezik, jezik_korisnika, korisnik WHERE jezik.id_jezika = jezik_korisnika.id_jezika AND korisnik.id_korisnika = jezik_korisnika.id_korisnika AND korisnik.id_korisnika = "+id;
            rss = st.executeQuery(sql2);
            while(rss.next()) {
                jezici.add(new Jezik(rss.getString("ime_jezika")));
            }
            st.close();

        } catch (SQLException ex) {
            System.err.println(ex);
        } finally {
            DB.getInstanca().putConnection(conn);
        }
        request.setAttribute("jezici", jezici);
        request.setAttribute("izabraniKorisnik", korisnik);
        RequestDispatcher rd = request.getRequestDispatcher("detaljiKorisnika.jsp");
        rd.forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
