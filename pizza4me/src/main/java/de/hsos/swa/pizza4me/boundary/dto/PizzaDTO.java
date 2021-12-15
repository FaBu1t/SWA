package de.hsos.swa.pizza4me.boundary.dto;

import de.hsos.swa.pizza4me.entity.Pizza;

public class PizzaDTO {
    public long id;
    public String name;
    public double preis;
    public String beschreibung;

    public PizzaDTO() {
    }

    public PizzaDTO(long id, String name, double preis, String beschreibung) {
        this.id = id;
        this.name = name;
        this.preis = preis;
        this.beschreibung = beschreibung;
    }

    public static class Converter {

        public static PizzaDTO toPizzaDTO(Pizza pizza) {
            PizzaDTO retPizzaDTO = new PizzaDTO(pizza.getId(), pizza.getName(), pizza.getPreis(),
                    pizza.getBeschreibung());
            return retPizzaDTO;
        }

        public static Pizza toPizza(PizzaDTO pizzaDTO) {
            Pizza pizza = new Pizza(pizzaDTO.name, pizzaDTO.preis, pizzaDTO.beschreibung);
            return pizza;
        }

    }

}
