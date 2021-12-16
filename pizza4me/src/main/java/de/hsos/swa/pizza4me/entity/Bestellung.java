package de.hsos.swa.pizza4me.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
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

    @OneToMany(cascade = CascadeType.ALL)
    private List<Bestellposten> bestellposten;

    public Bestellung() {
        this.bestellt = false;
        bestellposten = new ArrayList<Bestellposten>();
    }

    public boolean isBestellt() {
        return bestellt;
    }

    public void setBestellt(boolean bestellt) {
        this.bestellt = bestellt;
    }

    public List<Bestellposten> getBestellposten() {
        return this.bestellposten;
    }

    public int getId() {
        return id;
    }

    public void addBestellposten(Bestellposten bestellposten) {
        this.bestellposten.add(bestellposten);
    }

    public boolean removeBestellposten(int bestellpostenId) {
        for (Bestellposten posten : bestellposten) {
            if (posten.getId() == bestellpostenId) {
                bestellposten.remove(posten);
                return true;
            }
        }
        return false;
    }

    public Optional<Bestellposten> findBestellposten(int bestellpostenId) {
        for (Bestellposten posten : bestellposten) {
            if (posten.getId() == bestellpostenId) {
                bestellposten.remove(posten);
                return Optional.ofNullable(posten);
            }
        }
        return Optional.empty();
    }
}
