package de.hsos.swa.mocktailApp.control;

import de.hsos.swa.mocktailApp.entity.Mocktail;

public interface Read {

    public Mocktail[] suchen(String name);

    public Mocktail suchen(int id);

}
