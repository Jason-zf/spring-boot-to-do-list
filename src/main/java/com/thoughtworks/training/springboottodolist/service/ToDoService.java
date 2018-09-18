package com.thoughtworks.training.springboottodolist.service;

import com.thoughtworks.training.springboottodolist.model.ToDo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ToDoService {

    private List<ToDo> toDoList = new ArrayList<>();

    public ToDoService() {
        toDoList.add(new ToDo(1L, "meeting", "To Do", new Date()));
        toDoList.add(new ToDo(2L, "meeting with LY", "To Do", new Date()));
        toDoList.add(new ToDo(3L, "learn", "In progress", new Date()));
        toDoList.add(new ToDo(4L, "preparation", "Finished", new Date()));
    }

    public List<ToDo> getToDoList() {
        return toDoList;
    }

    public ToDo getToDoById(Long id) {
        return toDoList.stream().filter(item -> item.getId().equals(id)).findFirst().get();
    }


    public void addToDo(ToDo toDo) {
        toDo.setId(Long.valueOf(toDoList.size() + 1));
        toDoList.add(toDo);
    }

    public void deleteById(Long id) {
        toDoList.remove(toDoList.stream().filter(item -> item.getId().equals(id)).findFirst().get());
    }

    public void update(Long id, ToDo toDo) {
        toDoList.stream().filter(item -> item.getId().equals(id)).findFirst().get().setName(toDo.getName()).setStatus(toDo.getStatus()).setDueDate(toDo.getDueDate());
    }
}
