package com.mro.quotation.quote;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

/**
 * Class for an OrderItem within the system. OrderItem is an item added to a quote.
 * OrderItems can have a separate cost and price and an optional complexity factor.
 *
 * @author: Chris Durnan
 */
@Entity
@Table
public class OrderItem {
    @Id
    @SequenceGenerator(
            name = "order_item_sequence",
            sequenceName = "order_item_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_item_sequence"
    )
    private Long itemID;

    @JsonProperty("orderItemName")
    @Column(nullable = false)
    private String name;

    @JsonProperty("orderItemQuantity")
    @Column(nullable = false)
    private int quantity;

    @JsonProperty("orderItemCost")
    @Column(nullable = false)
    private double cost;

    @JsonProperty("orderItemPRice")
    @Column(nullable = false)
    private double price;

    @JsonProperty("orderItemComplexFactor")
    private double complexityFactor;

    @JsonProperty("orderItemComplexDesc")
    private String complexityDescription;

    public OrderItem() {}

    public OrderItem(String name, int quantity, double cost, double price, double complexityFactor, String complexityDescription) {
        this.name = name;
        this.quantity = quantity;
        this.cost = cost;
        this.price = price;
        this.complexityFactor = complexityFactor;
        this.complexityDescription = complexityDescription;
    }

    public Long getItemID() {
        return itemID;
    }

    public void setItemID(Long itemID) {
        this.itemID = itemID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getComplexityFactor() {
        return complexityFactor;
    }

    public void setComplexityFactor(double complexityFactor) {
        this.complexityFactor = complexityFactor;
    }

    public String getComplexityDescription() {
        return complexityDescription;
    }

    public void setComplexityDescription(String complexityDescription) {
        this.complexityDescription = complexityDescription;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "itemID=" + itemID +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", cost=" + cost +
                ", price=" + price +
                ", complexityFactor=" + complexityFactor +
                ", complexityDescription='" + complexityDescription + '\'' +
                '}';
    }
}
