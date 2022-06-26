package com.example.take_project.dto.clientpackage;

import java.math.BigDecimal;
import java.util.Optional;

public class UpdatedClientPackageDto {
    private Long id;
    private String deliveryAddress;
    private String type;
    private Integer weight;
    private Boolean isPaidFor;
    private BigDecimal price;
    private Long packageOwnerId;
    private Optional<Long> packageRouteId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Boolean getPaidFor() {
        return isPaidFor;
    }

    public void setPaidFor(Boolean paidFor) {
        isPaidFor = paidFor;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getPackageOwnerId() {
        return packageOwnerId;
    }

    public void setPackageOwnerId(Long packageOwnerId) {
        this.packageOwnerId = packageOwnerId;
    }

    public Optional<Long> getPackageRouteId() {
        return packageRouteId;
    }

    public void setPackageRouteId(Optional<Long> packageRouteId) {
        this.packageRouteId = packageRouteId;
    }
}
