package com.example.take_project.dto.clientpackage;

import java.sql.Date;

public class NewRouteCarsDefinedRouteDto {

    private Long id;

    private Date date;

    private Long carId;

    private Long definedRouteId;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    public Long getCarId() { return carId;  }

    public void setCarId(Long carId) { this.carId = carId; }

    public Long getDefinedRouteId() { return definedRouteId; }

    public void setDefinedRouteId(Long definedRouteId) { this.definedRouteId = definedRouteId; }
}
