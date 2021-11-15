package de.hsos.swa.mocktailApp.entity;

public class Mocktail {
    private int id;
    private String name;
    private String zutaten;
    private String autor;

    public Mocktail(int id, String name, String zutaten, String autor) {
        this.id = id;
        this.name = name;
        this.zutaten = zutaten;
        this.autor = autor;
    }

    public String getZutaten() {
        return zutaten;
    }

    public String getAutor() {
        return autor;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        String ret;
        ret = "{ " + this.name + ", " + this.id + " ," + zutaten + " ,";

        ret += autor + "}";

        return ret;
    }
}
