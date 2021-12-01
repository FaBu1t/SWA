package de.hsos.swa.auftragsverwaltung.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import de.hsos.swa.auftragsverwaltung.boundary.dto.OrderDTO;

@Entity
@Table(name ="orders")
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

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Order(int orderId, String description, Date orderOfReceipt, String shipURL) {
        this.orderId = orderId;
        this.description = description;
        this.orderOfReceipt = orderOfReceipt;
        this.shipURL = shipURL;
    }

    public Order(String description, Date orderOfReceipt, String shipURL) {
        this.description = description;
        this.orderOfReceipt = orderOfReceipt;
        this.shipURL = shipURL;
    }

    public Order() {
    }

   

    public int getOrderId() {
        return this.orderId;
    }

    public static class Converter {
        public static OrderDTO toDto(Order order) {
            return new OrderDTO(order.orderId, order.description, order.orderOfReceipt, order.shipURL);
        }

        public static Order toOrder(OrderDTO orderDto) {
            return new Order(orderDto.orderId, orderDto.description, orderDto.orderOfReceipt, orderDto.shipURL);
        }
    }
}
