package de.hsos.swa.mocktailApp.control;

import java.util.List;

import de.hsos.swa.mocktailApp.entity.MocktailDTO;

public interface Read {

    public List<MocktailDTO> suchen(String name);

    public MocktailDTO suchen(int id);

}
