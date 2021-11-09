package de.hsos.swa.mocktail.control;

import de.hsos.swa.mocktail.entity.Mocktail;

public interface Read {

    public Mocktail[] suchen(String name);

    public Mocktail suchen(int id);

}
