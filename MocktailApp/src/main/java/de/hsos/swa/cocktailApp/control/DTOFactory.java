package de.hsos.swa.cocktailApp.control;

import java.util.ArrayList;
import java.util.List;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import de.hsos.swa.cocktailApp.entity.CocktailDTO;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

public class DTOFactory {

    public List<CocktailDTO> getCocktailDto(JsonObject json) {
        JsonArray cocktails = json.getJsonArray("drinks");
        ArrayList<CocktailDTO> cocktailDTOs = new ArrayList<>();
        for (Object o : cocktails) {
            cocktailDTOs.add(getCocktailDTOfromJsonObject((JsonObject) o));
        }
        return cocktailDTOs;
    }

    private CocktailDTO getCocktailDTOfromJsonObject(JsonObject cocktail) {
        CocktailDTO cocktailDto = new CocktailDTO();
        cocktailDto.name = cocktail.getString("strDrink");
        cocktailDto.id = Integer.parseInt(cocktail.getString("idDrink"));
        String[] zutaten = new String[15];
        for (int i = 0; i < 15; i++) {
            String ingredient = cocktail.getString("strIngredient" + String.valueOf(i + 1));
            //System.out.println(ingredient);
            if (ingredient != null) {
                zutaten[i] = ingredient;
            }
        }

        cocktailDto.zutaten = zutaten;

        return cocktailDto;
    }

}
