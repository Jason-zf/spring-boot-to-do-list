package com.thoughtworks.training.springboottodolist.service;

import com.thoughtworks.training.springboottodolist.exception.NotFoundException;
import com.thoughtworks.training.springboottodolist.model.ToDo;
import com.thoughtworks.training.springboottodolist.repository.TagRepository;
import com.thoughtworks.training.springboottodolist.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    @Autowired
    TagRepository tagRepository;

    public ToDoService() {
//        Tag tag1 = new Tag("C++");
//        Tag tag2 = new Tag("Java");
//        Tag tag3 = new Tag("Javascript");
//        Tag tag4 = new Tag("python");
//
//        ToDo toDo = new ToDo("test2", "To Do", new Date(), ImmutableList.of(tag2, tag3));
//        ToDo toDo1 = new ToDo("test1", "In progress", new Date(), ImmutableList.of(tag1));
//        ToDo toDo2 = new ToDo("world", "Blocked", new Date(), ImmutableList.of(tag1, tag4));
//        ToDo toDo3 = new ToDo("hello", "In progress", new Date(), ImmutableList.of(tag4));
//        ToDo toDo4 = new ToDo("hack", "To Do", new Date(), ImmutableList.of(tag1, tag3));
//
//        toDoRepository.save(ImmutableList.of(toDo, toDo1, toDo2, toDo3, toDo4));
//        tag1.setToDos(ImmutableList.of(toDo1, toDo2, toDo4));
//        tag2.setToDos(ImmutableList.of(toDo));
//        tag3.setToDos(ImmutableList.of(toDo, toDo4));
//        tag4.setToDos(ImmutableList.of(toDo2, toDo3));
//
//        tagRepository.save(ImmutableList.of(tag1, tag2, tag3, tag4));

    }

    public List<ToDo> getToDoList() {
        return toDoRepository.findAll();
    }

    public ToDo getToDoById(Long id) throws NotFoundException {
        if (toDoRepository.findOne(id) == null) {
            throw new NotFoundException();
        }
        return toDoRepository.findOne(id);
    }


    public ToDo addToDo(ToDo toDo) {
        tagRepository.save(toDo.getTags());
        return toDoRepository.save(toDo);
    }

    public void deleteById(Long id) throws NotFoundException {
        if (toDoRepository.findOne(id) != null)
            toDoRepository.delete(id);
        else
            throw new NotFoundException();
    }

    public ToDo update(Long id, ToDo toDo) throws NotFoundException {
        if (toDoRepository.findOne(id) != null) {
            toDoRepository.save(toDo);
            return toDo;
        } else {
            throw new NotFoundException();
        }

    }

    public Page<ToDo> findAllByPage(Pageable toDoPageable) {
        return toDoRepository.findAll(toDoPageable);
    }
}
