package com.thoughtworks.training.springboottodolist.repository;

import com.thoughtworks.training.springboottodolist.model.ToDo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@DataJpaTest
@RunWith(SpringRunner.class)
public class ToDoRepositoryTest {

    @Autowired
    private ToDoRepository toDoRepository;

    @Test
    public void shouldGetToDoById() {
        toDoRepository.save(ToDo.builder().name("test").status("In propgress").build());
        ToDo toDo = toDoRepository.findOne(1L);

        assertEquals("test", toDo.getName());
        assertEquals("In progress", toDo.getStatus());
    }
}