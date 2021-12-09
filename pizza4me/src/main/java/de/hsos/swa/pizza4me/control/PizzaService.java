package de.hsos.swa.pizza4me.control;

import java.util.List;

import de.hsos.swa.pizza4me.entity.Pizza;

public interface PizzaService {

    public List<Pizza> allePizzenAbfragen();

    public List<Pizza> suchePizzaNachName(String name);

    public Pizza suchePizzaNachId(Long id);

    public void pizzaAnlegen(Pizza pizza);
    
}
