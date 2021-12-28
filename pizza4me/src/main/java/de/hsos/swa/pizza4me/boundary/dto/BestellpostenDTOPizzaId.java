package de.hsos.swa.pizza4me.boundary.dto;

import de.hsos.swa.pizza4me.entity.Bestellposten;
import de.hsos.swa.pizza4me.entity.Pizza;

public class BestellpostenDTOPizzaId {
    public int menge;
    public long pizza;

    public BestellpostenDTOPizzaId() {
    }

    public BestellpostenDTOPizzaId(int menge, long pizzaId) {
        this.menge = menge;
        this.pizza = pizzaId;
    }

    public static class Converter {
        public static BestellpostenDTOPizzaId toBestellpostenDTO(Bestellposten bestellposten) {
            BestellpostenDTOPizzaId retBestellpostenDTOPizzaId = new BestellpostenDTOPizzaId(bestellposten.getMenge(),
                    bestellposten.getPizza().getId());
            return retBestellpostenDTOPizzaId;
        }

        public static Bestellposten toBestellposten(BestellpostenDTOPizzaId bDTO, PizzaDTO pizza) {
            Bestellposten bestellPosten = new Bestellposten(PizzaDTO.Converter.toPizza(pizza), bDTO.menge);
            return bestellPosten;
        }

    }

}
