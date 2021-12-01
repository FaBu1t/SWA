package de.hsos.swa.auftragsverwaltung.boundary.dto;

import java.util.Date;

public class OrderDTO {
    public int orderId;
    public String description;
    public Date orderOfReceipt;
    public String shipURL;
    
    public OrderDTO(int orderId, String description, Date orderOfReceipt, String shipURL) {
        this.orderId = orderId;
        this.description = description;
        this.orderOfReceipt = orderOfReceipt;
        this.shipURL = shipURL;
    }

    

}
