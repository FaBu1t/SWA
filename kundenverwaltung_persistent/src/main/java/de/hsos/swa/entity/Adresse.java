package de.hsos.swa.entity;

public class Adresse {
    private String plz;
    private String ort;
    private String strasse;
    private String hausnr;

    public String getHausnr() {
        return hausnr;
    }
    public String getPlz() {
        return plz;
    }
    public void setPlz(String plz) {
        this.plz = plz;
    }
    public String getOrt() {
        return ort;
    }
    public void setOrt(String ort) {
        this.ort = ort;
    }
    public String getStrasse() {
        return strasse;
    }
    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }
    public void setHausnr(String hausnr) {
        this.hausnr = hausnr;
    }
    
}
