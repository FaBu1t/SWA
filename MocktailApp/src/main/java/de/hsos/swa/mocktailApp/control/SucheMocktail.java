package de.hsos.swa.mocktailApp.control;

import de.hsos.swa.mocktailApp.entity.Mocktail;
import de.hsos.swa.mocktailApp.entity.MocktailKatalog;
import de.hsos.swa.mocktailApp.gateway.MocktailRepository;

public class SucheMocktail {
    public Mocktail[] suchen(String name) {
        MocktailKatalog mocktailKatalog = MocktailRepository.getInstance();
        return mocktailKatalog.mocktailSuchen(name);

    }

    public Mocktail suchen(int id) {
        MocktailKatalog mocktailKatalog = MocktailRepository.getInstance();
        return mocktailKatalog.mocktailSuchen(id);

    }
}
