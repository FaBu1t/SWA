package de.hsos.swa.auftragsverwaltung.control;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import de.hsos.swa.auftragsverwaltung.boundary.dto.OrderDTO;
import de.hsos.swa.auftragsverwaltung.entity.Order;

@ApplicationScoped
public class OrderService {

    @Inject
    EntityManager em;

    @Transactional
    public Order createOrder(OrderDTO newOrder) {
        Order order = Order.Converter.toOrder(newOrder);
        em.persist(order);
        return order;
    }
}
