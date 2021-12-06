package de.hsos.swa.entity;

import javax.enterprise.inject.Vetoed;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "aktuelle_adressen")
@Vetoed
public class Adresse {
    @Id
    @SequenceGenerator(name = "adresseSequence", sequenceName = "aktuelle_adressen_id_seq", allocationSize = 1, initialValue = 1000)
    @GeneratedValue(generator = "adressenSequence")
    private Long id;
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
