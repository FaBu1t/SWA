package de.hsos.swa.mocktailApp.control;

import de.hsos.swa.mocktailApp.entity.Mocktail;
import de.hsos.swa.mocktailApp.entity.MocktailKatalog;
import de.hsos.swa.mocktailApp.gateway.MocktailRepository;

public class FuegeMocktailHinzu {
    public boolean create(Mocktail mocktail) {
        MocktailKatalog mocktailKatalog = MocktailRepository.getInstance();

        return mocktailKatalog.mocktailHinzufuegen(mocktail);
    }
}
