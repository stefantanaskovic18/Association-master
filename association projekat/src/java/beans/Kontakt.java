package beans;

public class Kontakt {
    private int idKontakta;
    private String adresa;
    private String brojTelefona;
    private String email;
    private String ziroRacun;
    private String pib;
    private String maticniBroj;

    public Kontakt() {
    }

    public Kontakt(int idKontakta, String adresa, String brojTelefona, String email, String ziroRacun, String pib, String maticniBroj) {
        this.idKontakta = idKontakta;
        this.adresa = adresa;
        this.brojTelefona = brojTelefona;
        this.email = email;
        this.ziroRacun = ziroRacun;
        this.pib = pib;
        this.maticniBroj = maticniBroj;
    }

    public int getIdKontakta() {
        return idKontakta;
    }

    public void setIdKontakta(int idKontakta) {
        this.idKontakta = idKontakta;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
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

    public String getZiroRacun() {
        return ziroRacun;
    }

    public void setZiroRacun(String ziroRacun) {
        this.ziroRacun = ziroRacun;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public String getMaticniBroj() {
        return maticniBroj;
    }

    public void setMaticniBroj(String maticniBroj) {
        this.maticniBroj = maticniBroj;
    }
    
    
    
}
