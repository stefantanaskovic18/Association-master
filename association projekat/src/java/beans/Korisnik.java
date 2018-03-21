package beans;

public class Korisnik {
    private int idKorisnika;
    private String username;
    private String password;
    private String ime;
    private String prezime;
    private String pol;
    private String mestoRodjenja;
    private String drzavaRodjenja;
    private String jmbg;
    private String brojTelefona;
    private String email;
    private int godinaUpisa;
    private int godinaZavrsetka;
    private String odsek;
    private int tip;
    private int racun;
    
    private String biografija;
    private String zaposlenje;
    private String vestina;
    private String nagrade;
    private String sertifikati;
    private String volonterskiRad;
    private int active;
    private int privatanNalog;

    public Korisnik(int idKorisnika, String username, String ime, String prezime, String pol, String mestoRodjenja, String drzavaRodjenja, String jmbg, String brojTelefona, String email, int godinaUpisa, int godinaZavrsetka, int active) {
        this.idKorisnika = idKorisnika;
        this.username = username;
        this.ime = ime;
        this.prezime = prezime;
        this.pol = pol;
        this.mestoRodjenja = mestoRodjenja;
        this.drzavaRodjenja = drzavaRodjenja;
        this.jmbg = jmbg;
        this.brojTelefona = brojTelefona;
        this.email = email;
        this.godinaUpisa = godinaUpisa;
        this.godinaZavrsetka = godinaZavrsetka;
        this.active = active;
    }

    
    
    
    
    public Korisnik() {
        biografija = null;
        zaposlenje = null;
        vestina = null;
        nagrade = null;
        sertifikati = null;
        volonterskiRad = null;
        active = -1;
        privatanNalog = -1;
    }

    public Korisnik(int idKorisnika, String username, String password, String ime, String prezime, String pol, String mestoRodjenja, String drzavaRodjenja, String jmbg, String brojTelefona, String email, int godinaUpisa, int godinaZavrsetka, String odsek, int tip, int racun) {
        this.idKorisnika = idKorisnika;
        this.username = username;
        this.password = password;
        this.ime = ime;
        this.prezime = prezime;
        this.pol = pol;
        this.mestoRodjenja = mestoRodjenja;
        this.drzavaRodjenja = drzavaRodjenja;
        this.jmbg = jmbg;
        this.brojTelefona = brojTelefona;
        this.email = email;
        this.godinaUpisa = godinaUpisa;
        this.godinaZavrsetka = godinaZavrsetka;
        this.odsek = odsek;
        this.tip = tip;
        this.racun = racun;
    }

    public Korisnik(int idKorisnika, String imeK, String prezimeK, String email, int godinaUpisaK, String odsekK, String zaposlenje) {
        this.idKorisnika = idKorisnika;
        this.ime = imeK;
        this.prezime = prezimeK;
        this.email = email;
        this.godinaUpisa = godinaUpisaK;
        this.odsek = odsekK;
        this.zaposlenje = zaposlenje;
    }

    public Korisnik(String ime, String prezime, String username) {
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
    }

    public Korisnik(int id, String username, String ime, String prezime, int aktivan) {
        this.idKorisnika = id;
        this.username = username;
        this.ime = ime;
        this.prezime = prezime;
        this.active = aktivan;
    }

    

    public String getBiografija() {
        return biografija;
    }

    public void setBiografija(String biografija) {
        this.biografija = biografija;
    }

    public String getZaposlenje() {
        return zaposlenje;
    }

    public void setZaposlenje(String zaposlenje) {
        this.zaposlenje = zaposlenje;
    }

    public String getVestina() {
        return vestina;
    }

    public void setVestina(String vestina) {
        this.vestina = vestina;
    }

    public String getNagrade() {
        return nagrade;
    }

    public void setNagrade(String nagrade) {
        this.nagrade = nagrade;
    }

    public String getSertifikati() {
        return sertifikati;
    }

    public void setSertifikati(String sertifikati) {
        this.sertifikati = sertifikati;
    }

    public String getVolonterskiRad() {
        return volonterskiRad;
    }

    public void setVolonterskiRad(String volonterskiRad) {
        this.volonterskiRad = volonterskiRad;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getPrivatanNalog() {
        return privatanNalog;
    }

    public void setPrivatanNalog(int privatanNalog) {
        this.privatanNalog = privatanNalog;
    }

    
    
    public int getIdKorisnika() {
        return idKorisnika;
    }

    public void setIdKorisnika(int idKorisnika) {
        this.idKorisnika = idKorisnika;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public String getMestoRodjenja() {
        return mestoRodjenja;
    }

    public void setMestoRodjenja(String mestoRodjenja) {
        this.mestoRodjenja = mestoRodjenja;
    }

    public String getDrzavaRodjenja() {
        return drzavaRodjenja;
    }

    public void setDrzavaRodjenja(String drzavaRodjenja) {
        this.drzavaRodjenja = drzavaRodjenja;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGodinaUpisa() {
        return godinaUpisa;
    }

    public void setGodinaUpisa(int godinaUpisa) {
        this.godinaUpisa = godinaUpisa;
    }

    public int getGodinaZavrsetka() {
        return godinaZavrsetka;
    }

    public void setGodinaZavrsetka(int godinaZavrsetka) {
        this.godinaZavrsetka = godinaZavrsetka;
    }

    public String getOdsek() {
        return odsek;
    }

    public void setOdsek(String odsek) {
        this.odsek = odsek;
    }

    public int getTip() {
        return tip;
    }

    public void setTip(int tip) {
        this.tip = tip;
    }

    public int getRacun() {
        return racun;
    }

    public void setRacun(int racun) {
        this.racun = racun;
    }
    
    

    
    
    
}
