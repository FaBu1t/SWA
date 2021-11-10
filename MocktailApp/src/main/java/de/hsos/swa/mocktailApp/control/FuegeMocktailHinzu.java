package de.hsos.swa.mocktailApp.control;

import de.hsos.swa.mocktailApp.entity.MocktailKatalog;
import de.hsos.swa.mocktailApp.gateway.MocktailRepository;

public class FuegeMocktailHinzu {
    public boolean create(int id, String name, String[] zutaten, String autor) {
        MocktailKatalog mocktailKatalog = MocktailRepository.getInstance();

        return mocktailKatalog.mocktailHinzufuegen(id, name, zutaten, autor);
    }
}
