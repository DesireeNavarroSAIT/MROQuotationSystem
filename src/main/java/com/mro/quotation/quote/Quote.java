package com.mro.quotation.quote;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

/**
 * Class for a Quote within the system. Contains information such as customer requesting and employee reviewing the quote.
 * Also other MRO specific attributes along with a list of OrderItems and Operations attached to the quote.
 * Entity and Table attributes are used by Spring Boot and Hibernate to signify this is an object to be persisted.
 * Id attribute indicates the primary key, which is automatically generated using the quote_no_sequence.
 *
 * @author: Chris Durnan
 */
@Entity
@Table(name="QUOTES")
public class Quote {
    @Id
    @SequenceGenerator(
            name = "quote_no_sequence",
            sequenceName = "quote_no_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "quote_no_sequence"
    )
    private Long quoteNumber;
    private Customer customer;
    private Employee employee;

    @JsonProperty("mroPartNumber")
    private String mroPartNumber;

    @JsonProperty("customerPartNumber")
    private String customerPartNumber;

    @JsonProperty("originator")
    private String originator;

    @JsonProperty("complexityFactor")
    private double complexityFactor;

    @JsonProperty("targetPricing")
    private double targetPricing;

    @JsonProperty("orderItemList")
    private List<OrderItem> orderItemList;

    @JsonProperty("operationsList")
    private List<Operations> operationsList;

    public Quote() {}

    public Quote(Customer customer, Employee employee, String mroPartNumber, String customerPartNumber,
                 String originator, double complexityFactor, double targetPricing,
                 List<OrderItem> orderItemList, List<Operations> operationsList) {
        this.customer = customer;
        this.employee = employee;
        this.mroPartNumber = mroPartNumber;
        this.customerPartNumber = customerPartNumber;
        this.originator = originator;
        this.complexityFactor = complexityFactor;
        this.targetPricing = targetPricing;
        this.orderItemList = orderItemList;
        this.operationsList = operationsList;
    }

    public Long getQuoteNumber() {
        return quoteNumber;
    }

    public void setQuoteNumber(Long quoteNumber) {
        this.quoteNumber = quoteNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getMroPartNumber() {
        return mroPartNumber;
    }

    public void setMroPartNumber(String mroPartNumber) {
        this.mroPartNumber = mroPartNumber;
    }

    public String getCustomerPartNumber() {
        return customerPartNumber;
    }

    public void setCustomerPartNumber(String customerPartNumber) {
        this.customerPartNumber = customerPartNumber;
    }

    public String getOriginator() {
        return originator;
    }

    public void setOriginator(String originator) {
        this.originator = originator;
    }

    public double getComplexityFactor() {
        return complexityFactor;
    }

    public void setComplexityFactor(double complexityFactor) {
        this.complexityFactor = complexityFactor;
    }

    public double getTargetPricing() {
        return targetPricing;
    }

    public void setTargetPricing(double targetPricing) {
        this.targetPricing = targetPricing;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public List<Operations> getOperationsList() {
        return operationsList;
    }

    public void setOperationsList(List<Operations> operationsList) {
        this.operationsList = operationsList;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "quoteNumber=" + quoteNumber +
                ", customer=" + customer +
                ", employee=" + employee +
                ", mroPartNumber='" + mroPartNumber + '\'' +
                ", customerPartNumber='" + customerPartNumber + '\'' +
                ", originator='" + originator + '\'' +
                ", complexityFactor=" + complexityFactor +
                ", targetPricing=" + targetPricing +
                ", orderItemList=" + orderItemList +
                ", operationsList=" + operationsList +
                '}';
    }
}
