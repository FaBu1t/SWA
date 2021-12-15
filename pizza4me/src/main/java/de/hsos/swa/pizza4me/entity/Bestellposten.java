package de.hsos.swa.pizza4me.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "bestellposten")
public class Bestellposten {
    @Id
    @SequenceGenerator(name = "bestellpostenSequenz", sequenceName = "bestellposten_id_seq", allocationSize = 1, initialValue = 1000)
    @GeneratedValue(generator = "bestellpostenSequenz")
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Pizza pizza;
    private int menge;

    public Bestellposten(Pizza pizza, int menge) {
        this.pizza = pizza;
        this.menge = menge;
    }

    public Bestellposten() {
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }

    public int getId() {
        return id;
    }

}
