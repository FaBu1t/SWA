package de.hsos.swa.mocktail.entity;

public class Mocktail {
    private int id;
    private String name;
    private String[] zutaten;
    private String autor;

    public Mocktail(int id, String name, String[] zutaten, String autor) {
        this.id = id;
        this.name = name;
        this.zutaten = zutaten;
        this.autor = autor;
    }

    
}
