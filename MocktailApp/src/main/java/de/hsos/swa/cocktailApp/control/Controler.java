package de.hsos.swa.cocktailApp.control;

import javax.enterprise.context.ApplicationScoped;

import de.hsos.swa.cocktailApp.entity.CocktailDTO;
import de.hsos.swa.cocktailApp.gateway.CocktailGateway;

@ApplicationScoped
public class Controler {
    CocktailGateway cocktailGateway = new CocktailGateway();

    public CocktailDTO getCocktailByName(String name) {
        return cocktailGateway.getCocktailByName(name);
    }

    public CocktailDTO getCocktailByID(int id) {
        return cocktailGateway.getCocktailByID(id);
    }

    public CocktailDTO searchCocktailByIngredient(String name) {
        return cocktailGateway.searchByIngredient(name);
    }
}
