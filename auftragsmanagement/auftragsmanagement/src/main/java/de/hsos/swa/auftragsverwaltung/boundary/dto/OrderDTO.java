package de.hsos.swa.auftragsverwaltung.boundary.dto;

import java.sql.Date;

public class OrderDTO {
    public int orderId;
    public String description;
    public Date orderOfReceipt;
    public String shipURL;
    public boolean confirmed;

    public OrderDTO(int orderId, String description, Date orderOfReceipt, String shipURL, boolean confirmed) {
        this.orderId = orderId;
        this.description = description;
        this.orderOfReceipt = orderOfReceipt;
        this.shipURL = shipURL;
        this.confirmed = confirmed;
    }

    public OrderDTO() {
    }

}
