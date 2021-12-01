package de.hsos.swa.Events;

import javax.enterprise.context.ApplicationScoped;

public class OrderDeleted {
    public int orderId;
    public String shipURL;
    public OrderDeleted(int orderId, String shipURL) {
        this.orderId = orderId;
        this.shipURL = shipURL;
    }

    

}
