package de.hsos.swa.mocktail.entity;

public interface MocktailKatalog {
    public Mocktail mocktailSuchen(String name);
    public boolean mocktailAendern();
    public void mocktailHinzufuegen(int id, String name, String[] zutaten, String autor);
    public boolean mocktailLoeschen(int id);
    public Mocktail mocktailSuchen(int id);
}