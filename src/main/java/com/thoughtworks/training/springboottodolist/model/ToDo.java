package com.thoughtworks.training.springboottodolist.model;

import java.util.Date;

public class ToDo {
    private Long id;
    private String name;
    private String status;
    private Date dueDate;

    public ToDo() {
    }

    public ToDo(Long id, String name, String status, Date dueDate) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.dueDate = dueDate;
    }

    public Long getId() {
        return id;
    }

    public ToDo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ToDo setName(String name) {
        this.name = name;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public ToDo setStatus(String status) {
        this.status = status;
        return this;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public ToDo setDueDate(Date dueDate) {
        this.dueDate = dueDate;
        return this;
    }
}
