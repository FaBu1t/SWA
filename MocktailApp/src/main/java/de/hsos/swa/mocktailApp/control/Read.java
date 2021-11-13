package de.hsos.swa.mocktailApp.control;

import java.util.List;

import de.hsos.swa.mocktailApp.entity.Mocktail;

public interface Read {

    public List<Mocktail> suchen(String name);

    public Mocktail suchen(int id);

}
