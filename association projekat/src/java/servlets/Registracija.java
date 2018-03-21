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

public class Registracija extends HttpServlet {

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
        int tip = Integer.parseInt(request.getParameter("tip"));
        
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String porukaRegistracije = "";
        try {
            conn = DB.getInstanca().getConnection();
            st = conn.createStatement();
            
            String provera = "SELECT id_korisnika FROM korisnik WHERE username = '"+username+"'";
            rs = st.executeQuery(provera);
            if(rs.next()) {
                porukaRegistracije = "Korisnicko ime vec postoji u bazi";
            }
            
            String sql = "INSERT INTO korisnik (username, password, ime, prezime, mesto_rodjenja, drzava_rodjenja, jmbg, broj_telefona, email, godina_upisa, godina_zavrsetka, odsek, tip, racun, pol"
                    + ") VALUES ('" + username + "', '" + password + "', '" + ime + "', '" + prezime + "', '" + mestoRodjenja + "', '" + drzavaRodjenja + "', '" + jmbg + "', '" + brojTelefona + "', '" + email + "', " + godinaUpisa + ", " + godinaZavrsetka + ", '" + odsek + "', "+tip+", 15000, '"+pol+"')";
            int ok = st.executeUpdate(sql);
            if(ok == 1) {
                if(tip == 2) {
                    String sql2 = "INSERT INTO alumni (id_korisnika, biografija, zaposlenje, vestina, nagrade, sertifikati, volonterski_rad, private, active) VALUES ((SELECT MAX(id_korisnika) FROM korisnik), '', '', '', '', '', '', 0, 1)";
                    int ok2 = st.executeUpdate(sql2);
                    if(ok2 == 1) {
                        porukaRegistracije = "Uspesno ste se registrovali kao alumni clan";
                    }else {
                        porukaRegistracije = "Greska prilikom registracije";
                    }
                }else {
                    porukaRegistracije = "Uspesno ste se registrovali kao blagajnik";
                }
            }
            st.close();
        }catch(SQLException ex) {
            System.err.println(ex);
        }finally {
            DB.getInstanca().putConnection(conn);
        }
        
        request.setAttribute("porukaRegistracije", porukaRegistracije);
        RequestDispatcher rd = request.getRequestDispatcher("registracija.jsp");
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
