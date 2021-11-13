package de.hsos.swa.mocktailApp.entity;

public class Mocktail {
    public int id;
    public String name;
    public String zutaten;
    public String autor;

    public Mocktail() {

    }

    public Mocktail(int id, String name, String zutaten, String autor) {
        this.id = id;
        this.name = name;
        this.zutaten = zutaten;
        this.autor = autor;
    }

    public void setZutaten(String zutaten) {
        this.zutaten = zutaten;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
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
