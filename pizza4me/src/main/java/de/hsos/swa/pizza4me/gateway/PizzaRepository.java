package de.hsos.swa.pizza4me.gateway;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import de.hsos.swa.pizza4me.control.PizzaService;
import de.hsos.swa.pizza4me.entity.Pizza;


@RequestScoped
@Named("PizzaRepo")
public class PizzaRepository implements PizzaService{

    @Override
    public List<Pizza> allePizzenAbfragen() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Pizza> suchePizzaNachName(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Pizza suchePizzaNachId(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void pizzaAnlegen(Pizza pizza) {
        // TODO Auto-generated method stub
        
    }
    
}
