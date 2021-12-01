package de.hsos.swa.Events;

public class OrderAccepted {
    public String shipUrl;
    public int orderId;

    public OrderAccepted(int orderId, String shipUrl) {
        this.shipUrl = shipUrl;
        this.orderId = orderId;
    }

}
