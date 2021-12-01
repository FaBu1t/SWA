package de.hsos.swa.auftragsverwaltung.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import de.hsos.swa.auftragsverwaltung.boundary.dto.OrderDTO;

@Entity
@NamedQuery(name = "Order.findAll", query = "SELECT f FROM Order f ORDER BY f.orderId", hints = @QueryHint(name = "org.hibernate.cacheable", value = "true"))
@Table(name = "orders")
public class Order {
    @Id
    @SequenceGenerator(name = "orderSeq", sequenceName = "order_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "orderSeq")
    private int orderId;

    @Column(length = 40)
    private String description;

    @Column(length = 20)
    private Date orderOfReceipt;

    @Column(length = 50)
    private String shipURL;

    public boolean confirmed;

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Order() {
    }

    public Order(int orderId, String description, Date orderOfReceipt, String shipURL, boolean confirmed) {
        this.orderId = orderId;
        this.description = description;
        this.orderOfReceipt = orderOfReceipt;
        this.shipURL = shipURL;
        this.confirmed = confirmed;
    }

    public Order(String description) {
        this.description = description;
        this.orderOfReceipt = new Date(System.currentTimeMillis());
        this.confirmed = false;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getOrderOfReceipt() {
        return orderOfReceipt;
    }

    public void setOrderOfReceipt(Date orderOfReceipt) {
        this.orderOfReceipt = orderOfReceipt;
    }

    public String getShipURL() {
        return shipURL;
    }

    public void setShipURL(String shipURL) {
        this.shipURL = shipURL;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public static class Converter {
        public static OrderDTO toDto(Order order) {
            return new OrderDTO(order.orderId, order.description, order.orderOfReceipt, order.shipURL, order.confirmed);
        }

        public static Order toOrder(OrderDTO orderDto) {
            return new Order(orderDto.orderId, orderDto.description, orderDto.orderOfReceipt, orderDto.shipURL,
                    orderDto.confirmed);
        }
    }
}
