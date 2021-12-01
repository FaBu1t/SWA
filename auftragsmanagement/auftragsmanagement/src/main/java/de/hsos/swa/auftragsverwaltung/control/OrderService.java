package de.hsos.swa.auftragsverwaltung.control;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import de.hsos.swa.Events.NewOrder;
import de.hsos.swa.Events.OrderDeleted;
import de.hsos.swa.auftragsverwaltung.boundary.dto.OrderDTO;
import de.hsos.swa.auftragsverwaltung.entity.Order;

@ApplicationScoped
public class OrderService {

    @Inject
    EntityManager em;

    @Inject
    Event<NewOrder> newOrderEvent;

    @Inject
    Event<OrderDeleted> orderDeletedEvent;

    @Transactional
    public Order createOrder(String description) {
        Order order = new Order(description);
        em.persist(order);
        newOrderEvent.fire(new NewOrder(order.getOrderId()));
        return order;
    }

    public Order getOrder(int id) {
        return em.find(Order.class, id);
    }

    @Transactional
    public Order changeOrder(OrderDTO newOrder) {
        Order entity = em.find(Order.class, newOrder.orderId);
        if (entity != null) {
            entity.setDescription(newOrder.description);
            entity.setOrderOfReceipt(newOrder.orderOfReceipt);
            entity.setConfirmed(newOrder.confirmed);
            entity.setShipURL(newOrder.shipURL);
            em.persist(entity);
            return entity;
        }
        return null;
    }

    @Transactional
    public Order deleteOrder(int id) {
        Order entity = em.find(Order.class, id);
        if (entity != null) {
            em.remove(entity);
            orderDeletedEvent.fire(new OrderDeleted(entity.getOrderId(), entity.getShipURL()));
        }
        return entity;
    }

    public List<Order> findAll() {
        return em.createNamedQuery("Order.findAll", Order.class)
                .getResultList();
    }

}
