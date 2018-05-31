package com.epam.alexadr_lobov.java.lesson_7.task_7;

import java.sql.Date;

public class Employer implements Cloneable {

    private Integer id;
    private String name;
    private String job;
    private Integer managerId;
    private Date hireDate;
    private Double sales;
    private Double commision;
    private Integer departamentId;

    public Employer(Integer id) {
        this(id, null, null, null, null, null, null, null);
    }

    public Employer(Employer other) {
        this(   other.getId(),
                other.getName(),
                other.getJob(),
                other.getManagerId(),
                other.getHireDate(),
                other.getSales(),
                other.getCommision(),
                other.getDepartamentId());
    }

    public Employer(Integer id,
                    String name,
                    String job,
                    Integer managerId,
                    Date hireDate,
                    Double sales,
                    Double commision,
                    Integer departament) {
        this.id = id;
        this.name = name;
        this.job = job;
        this.managerId = managerId;
        this.hireDate = hireDate;
        this.sales = sales;
        this.commision = commision;
        this.departamentId = departament;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Double getSales() {
        return sales;
    }

    public void setSales(Double sales) {
        this.sales = sales;
    }

    public Double getCommision() {
        return commision;
    }

    public void setCommision(Double commision) {
        this.commision = commision;
    }

    public Integer getDepartamentId() {
        return departamentId;
    }

    public void setDepartamentId(Integer departamentId) {
        this.departamentId = departamentId;
    }

    @Override
    public Employer clone() {
        return new Employer(this);
    }
}
