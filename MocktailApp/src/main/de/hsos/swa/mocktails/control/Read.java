package de.hsos.swa.mocktails.control;

import de.hsos.swa.mocktails.entity.Mocktail;

public interface Read {

    public Mocktail[] suchen(String name);

    public Mocktail suchen(int id);

}
