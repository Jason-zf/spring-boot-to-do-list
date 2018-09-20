package com.thoughtworks.training.springboottodolist.model;

import lombok.Builder;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class ToDo {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String status;
    private Date dueDate;


    @ManyToMany
    @JoinTable(name = "todo_tags", joinColumns = @JoinColumn(name = "todo_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags;

    public ToDo() {
    }

    public ToDo(String name, String status, Date dueDate, List<Tag> tags) {
        this.name = name;
        this.status = status;
        this.dueDate = dueDate;
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
