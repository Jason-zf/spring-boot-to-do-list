package com.thoughtworks.training.springboottodolist.controller;

import com.thoughtworks.training.springboottodolist.exception.NotFoundException;
import com.thoughtworks.training.springboottodolist.model.ToDo;
import com.thoughtworks.training.springboottodolist.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public ToDo getToDoById(@PathVariable Long id) throws NotFoundException {
        return toDoService.getToDoById(id);
    }

    @PostMapping
    public ToDo addToDo(@RequestBody ToDo toDo) {
        return toDoService.addToDo(toDo);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) throws NotFoundException {
        toDoService.deleteById(id);
    }

    @PutMapping
    public void update(@RequestBody ToDo toDo) throws NotFoundException {
        toDoService.update(toDo.getId(), toDo);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Page<ToDo> getItemsByPageAndSize(Pageable pageable) {
        Page<ToDo> result = toDoService.findAllByPage(pageable);
        return result;
    }

}
