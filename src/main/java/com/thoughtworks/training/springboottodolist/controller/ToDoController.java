package com.thoughtworks.training.springboottodolist.controller;

import com.thoughtworks.training.springboottodolist.model.ToDo;
import com.thoughtworks.training.springboottodolist.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @GetMapping
    public List<ToDo> getAllToDoItems() {
        return toDoService.getToDoList();
    }

    @GetMapping(value = "/{id}")
    public ToDo getToDoById(@PathVariable Long id) {
        return toDoService.getToDoById(id);
    }

    @PostMapping
    public void addToDo(@RequestBody ToDo toDo) {
        toDoService.addToDo(toDo);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        toDoService.deleteById(id);
    }

    @RequestMapping(value = "/update/{id}")
    public void update(@PathVariable Long id,@RequestBody ToDo toDo){
        toDoService.update(id,toDo);
    }

}
