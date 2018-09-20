package com.thoughtworks.training.springboottodolist.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.List;

@Entity
public class Tag implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Tag() {
    }

    public Tag(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "tags")
    private List<ToDo> toDos;

    public void add(ToDo toDo) {
        this.toDos.add(toDo);
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

    public List<ToDo> getToDos() {
        return toDos;
    }

    public void setToDos(List<ToDo> toDos) {
        this.toDos = toDos;
    }
}
