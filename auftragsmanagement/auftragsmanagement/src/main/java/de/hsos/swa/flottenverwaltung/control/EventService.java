package de.hsos.swa.flottenverwaltung.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.ws.rs.core.UriBuilder;

import de.hsos.swa.Events.NewOrder;
import de.hsos.swa.Events.OrderAccepted;
import de.hsos.swa.Events.OrderDeleted;
import de.hsos.swa.flottenverwaltung.boundary.rest.flottenRessource;
import de.hsos.swa.flottenverwaltung.entity.Schiff;

public class EventService {

    @Inject
    Flottenmanagement flottenManagement;

    @Inject
    Event<OrderAccepted> orderAcceptEvent;

    private String schiffsUri(Long shipId) {
        return UriBuilder.fromResource(flottenRessource.class).path(flottenRessource.class, "sucheSchiff")
                .build(shipId).toString();

    }

    public void newOrder(@Observes NewOrder newOrder) {
        List<Schiff> freieSchiffe = flottenManagement.sucheFreieSchiffe();
        Optional<Schiff> freiesSchiff = freieSchiffe.stream().findFirst();
        if (freiesSchiff.isPresent()) {
            orderAcceptEvent.fire(new OrderAccepted(newOrder.orderId, schiffsUri(freiesSchiff.get().getId())));
            flottenManagement.setSchiffGebucht(freiesSchiff.get().getId(), true);
        }
    }

    public void deleteOrder(@Observes OrderDeleted orderDeleted) {
        if (orderDeleted.shipURL != null) {
            String[] splitURL = orderDeleted.shipURL.split("/");
            Long shipId = Long.valueOf(splitURL[splitURL.length - 1]);
            flottenManagement.setSchiffGebucht(shipId, false);
        }
    }
}
