package de.hsos.swa.entity;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Vetoed;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.QueryHint;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "aktuelle_kunden")
@NamedQuery(name = "Kunde.findAll", query = "SELECT k FROM Kunde k ORDER BY k.nachname", hints = @QueryHint(name = "org.hibernate.cacheable", value = "true"))
@Cacheable
@Vetoed
public class Kunde {
    @Id
    @SequenceGenerator(name = "kundenSequence", sequenceName = "aktuelle_kunden_id_seq", allocationSize = 1, initialValue = 1000)
    @GeneratedValue(generator = "kundenSequence")
    private Long id;

    private String vorname;
    private String nachname;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Adresse adresse;

    public Kunde() {
    }

    public Kunde(String vorname, String nachname) {
        this.vorname = vorname;
        this.nachname = nachname;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public Long getId() {
        return this.id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
}
