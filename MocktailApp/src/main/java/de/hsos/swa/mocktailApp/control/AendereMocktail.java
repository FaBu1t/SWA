package de.hsos.swa.mocktailApp.control;

import de.hsos.swa.mocktailApp.entity.MocktailKatalog;
import de.hsos.swa.mocktailApp.gateway.MocktailRepository;

public class AendereMocktail {
    public boolean aendere(int id, String name, String[] zutaten, String Autor) {
        MocktailKatalog mocktailKatalog = MocktailRepository.getInstance();
        return mocktailKatalog.mocktailAendern(id, name, zutaten, Autor);
    }

}
