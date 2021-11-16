package de.hsos.swa.mocktailApp.control;

import java.util.List;

public interface Read {

    public List<MocktailDTO> suchen(String name);

    public MocktailDTO suchen(int id);

}
