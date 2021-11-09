package de.hsos.swa.mocktailApp.control;

import de.hsos.swa.mocktailApp.entity.MocktailKatalog;
import de.hsos.swa.mocktailApp.gateway.MocktailRepository;

public class EntferneMocktail {
    public boolean delete(int id) {
        MocktailKatalog mocktailKatalog = MocktailRepository.getInstance();
        return mocktailKatalog.mocktailLoeschen(id);
    }
}
