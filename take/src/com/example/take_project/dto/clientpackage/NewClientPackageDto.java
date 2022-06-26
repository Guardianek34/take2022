package com.example.take_project.dto.clientpackage;

import com.example.take_project.models.Route;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Optional;

import javax.persistence.Column;

public class NewClientPackageDto {
    private String deliveryAddress;
    private String type;
    private Integer weight;
    private Boolean paidFor;
    private BigDecimal price;
    private Long packageOwnerId;
    private Date estimatedDeliveryDate;

    @Column(nullable = true)
    private Long packageRouteId;


    public Optional<Long> getPackageRouteId() {
        return Optional.ofNullable(packageRouteId);
    }

    public void setPackageRouteId(Long packageRouteId) {
        this.packageRouteId = packageRouteId;
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
        return paidFor;
    }

    public void setPaidFor(Boolean paidFor) {
        this.paidFor = paidFor;
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

    public Date getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(Date estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }
}
