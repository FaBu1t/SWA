package de.hsos.swa.pizza4me.entity;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Vetoed;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "kunden")
@Cacheable
@Vetoed
public class Kunde {
    @Id
    @SequenceGenerator(name = "kundenSequenz", sequenceName = "kunden_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "kundenSequenz")
    private int id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Bestellung> bestellungen;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_adressId", referencedColumnName = "id")
    private Adresse adresse;

    public Kunde() {
        bestellungen = new ArrayList<Bestellung>();
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public List<Bestellung> getBestellungen() {
        return bestellungen;
    }

    public void setBestellungen(List<Bestellung> bestellungen) {
        this.bestellungen = bestellungen;
    }

    public int getId() {
        return id;
    }

    public void addBestellung(Bestellung bestellung) {
        this.bestellungen.add(bestellung);
    }

    public void deleteBestellung(int bestellungId) {
        if (this.bestellungen == null) {
            System.out.println("Bestellungen = null");
            return;
        }
        for (int i = 0; i < bestellungen.size(); i++) {
            if (bestellungen.get(i).getId() == bestellungId) {
                bestellungen.remove(i);
            }
        }
    }

}
