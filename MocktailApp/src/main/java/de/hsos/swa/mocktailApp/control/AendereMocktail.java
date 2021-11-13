package de.hsos.swa.mocktailApp.control;

import de.hsos.swa.mocktailApp.entity.Mocktail;
import de.hsos.swa.mocktailApp.entity.MocktailKatalog;
import de.hsos.swa.mocktailApp.gateway.MocktailRepository;

public class AendereMocktail {
    public boolean aendere(Mocktail mocktail) {
        MocktailKatalog mocktailKatalog = MocktailRepository.getInstance();
        return mocktailKatalog.mocktailAendern(mocktail);
    }

}
