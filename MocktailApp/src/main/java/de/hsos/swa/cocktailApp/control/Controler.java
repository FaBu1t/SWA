package de.hsos.swa.cocktailApp.control;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import de.hsos.swa.cocktailApp.entity.CocktailDTO;
import de.hsos.swa.cocktailApp.gateway.CocktailGateway;

@ApplicationScoped
public class Controler {

    @Inject
    CocktailGateway cocktailGateway;

    public List<CocktailDTO> getCocktailByName(String name) {
        return cocktailGateway.getCocktailByName(name);
    }

    public List<CocktailDTO> getCocktailByID(int id) {
        return cocktailGateway.getCocktailByID(id);
    }

    public List<CocktailDTO> searchCocktailByIngredient(String name) {
        return cocktailGateway.searchByIngredient(name);
    }
}
