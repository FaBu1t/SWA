package de.hsos.swa.pizza4me.entity;

import javax.enterprise.inject.Vetoed;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "adressen", schema = "DATA")
@Vetoed
public class Adresse {
    @Id
    @SequenceGenerator(name = "adresseSequenz", sequenceName = "adressen_id_seq", allocationSize = 1, initialValue = 1000)
    @GeneratedValue(generator = "adressenSequenz")
    private int id;

    private String strasse;
    private String ort;
    private int plz;

    public Adresse() {
    }

    public Adresse(String strasse, String ort, int plz) {
        this.strasse = strasse;
        this.ort = ort;
        this.plz = plz;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public int getPlz() {
        return plz;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }

    public int getId() {
        return id;
    }

}
