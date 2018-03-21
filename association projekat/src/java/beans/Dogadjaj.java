package beans;

public class Dogadjaj {
    private int id_dogadjaja;
    private String naslov;
    private String sadrzaj;
    private String datumPostavljanja;
    private String slika;
    private String datumOdrzavanja;
    private String mesto;

    public Dogadjaj() {
    }

    
    public Dogadjaj(int id_dogadjaja, String naslov, String sadrzaj, String datumPostavljanja, String slika, String datumOdrzavanja, String mesto) {
        this.id_dogadjaja = id_dogadjaja;
        this.naslov = naslov;
        this.sadrzaj = sadrzaj;
        this.datumPostavljanja = datumPostavljanja;
        this.slika = slika;
        this.datumOdrzavanja = datumOdrzavanja;
        this.mesto = mesto;
    }

    public int getId_dogadjaja() {
        return id_dogadjaja;
    }

    public void setId_dogadjaja(int id_dogadjaja) {
        this.id_dogadjaja = id_dogadjaja;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getSadrzaj() {
        return sadrzaj;
    }

    public void setSadrzaj(String sadrzaj) {
        this.sadrzaj = sadrzaj;
    }

    public String getDatumPostavljanja() {
        return datumPostavljanja;
    }

    public void setDatumPostavljanja(String datumPostavljanja) {
        this.datumPostavljanja = datumPostavljanja;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    public String getDatumOdrzavanja() {
        return datumOdrzavanja;
    }

    public void setDatumOdrzavanja(String datumOdrzavanja) {
        this.datumOdrzavanja = datumOdrzavanja;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }
    
    
    
    
}
