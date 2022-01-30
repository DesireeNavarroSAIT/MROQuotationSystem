package com.mro.quotation.quote;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

/**
 * Class for an Operation within the system.
 * Operations are optionally added to a Quote by an MRO employee.
 *
 * @author Chris Durnan
 */
@Entity
@Table
public class Operation {
    @Id
    @SequenceGenerator(
            name = "operation_no_sequence",
            sequenceName = "operation_no_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "operation_no_sequence"
    )
    private Long operationId;

    @JsonProperty("operationName")
    private String name;

    @JsonProperty("numberOfOperations")
    private double numberOfOperations;

    @JsonProperty("estimatedTime")
    private double estimatedTime;

    @JsonProperty("totalTime")
    private double totalTime;

    @JsonProperty("operationTotalCost")
    private double totalCost;

    public Operation() {}

    public Operation(String name, double numberOfOperations, double estimatedTime, double totalTime, double totalCost) {
        this.name = name;
        this.numberOfOperations = numberOfOperations;
        this.estimatedTime = estimatedTime;
        this.totalTime = totalTime;
        this.totalCost = totalCost;
    }

    public Long getOperationId() {
        return operationId;
    }

    public void setOperationId(Long operationId) {
        this.operationId = operationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNumberOfOperations() {
        return numberOfOperations;
    }

    public void setNumberOfOperations(double numberOfOperations) {
        this.numberOfOperations = numberOfOperations;
    }

    public double getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(double estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "operationId=" + operationId +
                ", name='" + name + '\'' +
                ", numberOfOperations=" + numberOfOperations +
                ", estimatedTime=" + estimatedTime +
                ", totalTime=" + totalTime +
                ", totalCost=" + totalCost +
                '}';
    }
}
