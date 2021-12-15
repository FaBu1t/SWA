package de.hsos.swa.pizza4me.gateway;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import de.hsos.swa.pizza4me.control.PizzaService;
import de.hsos.swa.pizza4me.entity.Pizza;
import io.quarkus.security.User;

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

        return em.createQuery("Select p from Pizza p where p.name=:name", Pizza.class).setParameter("name", name)
                .getResultList();
    }

    @Override
    public Pizza suchePizzaNachId(Long id) {

        return em.find(Pizza.class, id);
    }

    @Override
    public void pizzaAnlegen(Pizza pizza) {
        // TODO Auto-generated method stub

    }

}
