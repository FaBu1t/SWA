package de.hsos.swa.pizza4me.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "pizzen")
@NamedQuery(name = "Pizza.findAll", query = "SELECT p FROM Pizza p ORDER BY p.id", hints = @QueryHint(name = "org.hibernate.cacheable", value = "true"))
public class Pizza {
    @Id
    @SequenceGenerator(name = "pizzaSequenz", sequenceName = "pizzen_id_seq", allocationSize = 1, initialValue = 1000)
    @GeneratedValue(generator = "pizzaSequenz")
    private int id;
    private String name;
    private double preis;
    private String beschreibung;

    public Pizza(String name, double preis, String beschreibung) {
        this.name = name;
        this.preis = preis;
        this.beschreibung = beschreibung;
    }

    public Pizza() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

}
