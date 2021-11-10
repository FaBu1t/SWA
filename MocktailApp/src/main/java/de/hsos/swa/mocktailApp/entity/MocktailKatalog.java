package de.hsos.swa.mocktailApp.entity;

import java.util.List;

public interface MocktailKatalog {

    public List<Mocktail> mocktailSuchen(String name);

    public boolean mocktailAendern(int id, String name, String[] zutaten, String autor);

    public boolean mocktailHinzufuegen(int id, String name, String[] zutaten, String autor);

    public boolean mocktailLoeschen(int id);

    public Mocktail mocktailSuchen(int id);
}
