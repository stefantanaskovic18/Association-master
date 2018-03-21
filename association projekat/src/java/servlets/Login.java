package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database.DB;
import beans.Korisnik;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession sesija = request.getSession();
        String username = (String) request.getParameter("username");
        String password = (String) request.getParameter("password");
        Korisnik korisnik = new Korisnik();

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String poruka = "";
        String adresa = "asd.jsp";

        try {
            conn = DB.getInstanca().getConnection();
            st = conn.createStatement();

            String sql = "SELECT * FROM korisnik WHERE username = '" + username + "' AND password = '" + password + "';";
            rs = st.executeQuery(sql);
            if (rs.next()) {

                int idKorisnika = rs.getInt("id_korisnika");
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
                int tip = rs.getInt("tip");
                int racun = rs.getInt("racun");

                String biografija = null;
                String zaposlenje = null;
                String vestina = null;
                String nagrade = null;
                String sertifikati = null;
                String volonterskiRad = null;
                int active = -1;
                int privatanNalog = -1;

                korisnik.setIdKorisnika(idKorisnika);
                korisnik.setUsername(username);
                korisnik.setPassword(password);
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
                korisnik.setTip(tip);
                korisnik.setRacun(racun);

                switch (tip) {
                    case 1:
                        adresa = "admin.jsp";
                        break;
                    case 2:
                        adresa = "alumni.jsp";
                        Connection con = null;
                        Statement sta = null;
                        ResultSet rss = null;
                        try {
                            con = DB.getInstanca().getConnection();
                            sta = con.createStatement();
                            String query = "SELECT * FROM alumni WHERE id_korisnika = "+idKorisnika+"";
                            rss = sta.executeQuery(query);
                            if(rss.next()) {
                                biografija = rss.getString("biografija");
                                zaposlenje = rss.getString("zaposlenje");
                                vestina = rss.getString("vestina");
                                nagrade = rss.getString("nagrade");
                                sertifikati = rss.getString("sertifikati");
                                volonterskiRad = rss.getString("volonterski_rad");
                                privatanNalog = rss.getInt("private");
                                active = rss.getInt("active");
                            }else {
                                
                            }
                            sta.close();
                        }catch(SQLException ex) {
                            System.err.println(ex);
                        }finally {
                            DB.getInstanca().putConnection(con);
                        }
                        break;
                    case 3:
                        adresa = "blagajnik.jsp";
                        break;
                    default:
                        adresa = "greska.jsp";
                        break;
                }

                korisnik.setBiografija(biografija);
                korisnik.setZaposlenje(zaposlenje);
                korisnik.setVestina(vestina);
                korisnik.setNagrade(nagrade);
                korisnik.setSertifikati(sertifikati);
                korisnik.setVolonterskiRad(volonterskiRad);
                korisnik.setActive(active);
                korisnik.setPrivatanNalog(privatanNalog);

                st.close();
                request.setAttribute("poruka", "Vasi podaci");
                sesija.setAttribute("korisnik", korisnik);
            } else {
                poruka = "Neispravno korisnicko ime ili sifra";
                request.setAttribute("poruka", poruka);
                adresa = "index.jsp";
                st.close();
            }

        } catch (SQLException ex) {
            adresa = "index.jsp";
        } finally {
            DB.getInstanca().putConnection(conn);
        }
        RequestDispatcher rd = request.getRequestDispatcher(adresa);
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
