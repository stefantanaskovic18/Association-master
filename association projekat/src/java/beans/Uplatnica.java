package beans;

public class Uplatnica {
    private String svrha;
    private String datum;
    private int kolicina;
    private Korisnik korisnik;

    public Uplatnica(String svrha, String datum, int kolicina) {
        this.svrha = svrha;
        this.datum = datum;
        this.kolicina = kolicina;
    }

    public Uplatnica(String svrha, String datum, int kolicina, Korisnik korisnik) {
        this.svrha = svrha;
        this.datum = datum;
        this.kolicina = kolicina;
        this.korisnik = korisnik;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
    
    
    
    public Uplatnica() {
    }

    public String getSvrha() {
        return svrha;
    }

    public void setSvrha(String svrha) {
        this.svrha = svrha;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }
    
    
}
