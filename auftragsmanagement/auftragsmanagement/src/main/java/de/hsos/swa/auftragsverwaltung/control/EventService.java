package de.hsos.swa.auftragsverwaltung.control;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import de.hsos.swa.Events.OrderAccepted;
import de.hsos.swa.auftragsverwaltung.entity.Order;

public class EventService {

    @Inject
    OrderService orderService;

    public void addShippingInfo(@Observes OrderAccepted orderAccepted) {
        Order order = orderService.getOrder(orderAccepted.orderId);
        if (order != null) {
            order.setConfirmed(true);
            order.setShipURL(orderAccepted.shipUrl);
        }
    }

}
