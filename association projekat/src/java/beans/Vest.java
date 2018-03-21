package beans;

public class Vest {
    private int id_vesti;
    private String naslov;
    private String sadrzaj;
    private String datumPostavljanja;
    private String slika;

    public Vest() {
        
    }

    public Vest(int id_vesti, String naslov, String sadrzaj) {
        this.id_vesti = id_vesti;
        this.naslov = naslov;
        this.sadrzaj = sadrzaj;
    }
    
    public Vest(int id_vesti, String naslov, String sadrzaj, String datumPostavljanja, String slika) {
        this.id_vesti = id_vesti;
        this.naslov = naslov;
        this.sadrzaj = sadrzaj;
        this.datumPostavljanja = datumPostavljanja;
        this.slika = slika;
    }

    public int getId_vesti() {
        return id_vesti;
    }

    public void setId_vesti(int id_vesti) {
        this.id_vesti = id_vesti;
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
    
    
    
}
