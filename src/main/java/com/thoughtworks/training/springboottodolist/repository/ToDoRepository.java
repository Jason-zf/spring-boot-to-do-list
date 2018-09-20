package com.thoughtworks.training.springboottodolist.repository;

import com.thoughtworks.training.springboottodolist.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {

}
