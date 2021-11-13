package de.hsos.swa.mocktailApp.entity;

import java.util.List;

public interface MocktailKatalog {

    public List<Mocktail> mocktailSuchen(String name);

    public boolean mocktailAendern(Mocktail mocktail);

    public boolean mocktailHinzufuegen(Mocktail mocktail);

    public boolean mocktailLoeschen(int id);

    public Mocktail mocktailSuchen(int id);
}
