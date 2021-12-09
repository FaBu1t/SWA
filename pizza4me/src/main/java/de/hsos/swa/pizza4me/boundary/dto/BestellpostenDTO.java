package de.hsos.swa.pizza4me.boundary.dto;

import de.hsos.swa.pizza4me.entity.Bestellposten;
import de.hsos.swa.pizza4me.entity.Pizza;

public class BestellpostenDTO {
    public int menge;
    public PizzaDTO pizzaDTO;

    public BestellpostenDTO(){}

    public BestellpostenDTO(int menge, PizzaDTO pizzaDTO){
        this.menge=menge;
        this.pizzaDTO=pizzaDTO;
    }


    public static class Converter{
        public static BestellpostenDTO toBestellpostenDTO(Bestellposten bestellposten){
            BestellpostenDTO retBestellpostenDTO= new BestellpostenDTO(bestellposten.getMenge(), PizzaDTO.Converter.toPizzaDTO(bestellposten.getPizza()));
            return retBestellpostenDTO; 
        }
        public static Bestellposten toBestellposten(BestellpostenDTO bDTO){
            Bestellposten bestellPosten= new Bestellposten(PizzaDTO.Converter.toPizza(bDTO.pizzaDTO),bDTO.menge);
            return bestellPosten;
        }

    }
    
}
