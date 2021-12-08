package de.hsos.swa.pizza4me.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "bestellungen")
public class Bestellung {
    @Id
    @SequenceGenerator(name = "bestellungSequenz", sequenceName = "bestellungen_id_seq", allocationSize = 1, initialValue = 1000)
    @GeneratedValue(generator = "bestellungSequenz")
    private int id;

    private boolean bestellt;

    @OneToMany
    private List<Bestellposten> bestellposten;

    public Bestellung() {
        this.bestellt = false;
    }

    public boolean isBestellt() {
        return bestellt;
    }

    public void setBestellt(boolean bestellt) {
        this.bestellt = bestellt;
    }

    public List<Bestellposten> getBestellposten() {
        return bestellposten;
    }

    public void setBestellposten(List<Bestellposten> bestellposten) {
        this.bestellposten = bestellposten;
    }

    public int getId() {
        return id;
    }

}
