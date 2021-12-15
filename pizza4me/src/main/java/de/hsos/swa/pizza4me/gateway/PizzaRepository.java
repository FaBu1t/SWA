package de.hsos.swa.pizza4me.gateway;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import de.hsos.swa.pizza4me.control.PizzaService;
import de.hsos.swa.pizza4me.entity.Pizza;

@RequestScoped
@Named("PizzaRepo")
public class PizzaRepository implements PizzaService {

    @Inject
    EntityManager em;

    @Override
    public List<Pizza> allePizzenAbfragen() {

        return em.createQuery("Select p from Pizza p", Pizza.class).getResultList();
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
