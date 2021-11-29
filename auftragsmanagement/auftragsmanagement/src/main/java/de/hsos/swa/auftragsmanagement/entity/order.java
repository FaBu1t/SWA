package de.hsos.swa.auftragsmanagement.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class order {
    private int orderId;
    private String description;
    private Date dateOfReceipt;
    private String shipURL;

    @Id
    @SequenceGenerator(name="orderSeq", sequenceName = "order_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator="orderSeq")
    public int getOrderId(){
        return orderId;
    }
}
