package com.thoughtworks.training.springboottodolist.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.thoughtworks.training.springboottodolist.exception.NotFoundException;
import com.thoughtworks.training.springboottodolist.model.Tag;
import com.thoughtworks.training.springboottodolist.model.ToDo;
import com.thoughtworks.training.springboottodolist.model.User;
import com.thoughtworks.training.springboottodolist.service.ToDoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.orm.hibernate4.SpringSessionContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@WebAppConfiguration
public class ToDoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ToDoService toDoService;

    @Before
    public void setUp() throws Exception {
        User user = new User("xiaoming", "123456");
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user, "", ImmutableList.of()));
    }

    @Test
    public void shouldGetAllToDoItems() throws Exception {
        ToDo toDo = new ToDo("test1", "In progress", new Date(), 1L, ImmutableList.of(new Tag()));
        ToDo toDo1 = new ToDo("test2", "To Do", new Date(), 1L, ImmutableList.of(new Tag()));

        Page<ToDo> toDoList = new PageImpl<>(ImmutableList.of(toDo, toDo1));

        given(toDoService.getToDoList(null, null, null, null)).willReturn(toDoList);

        mockMvc.perform(get("/todos"))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].action").value("test1"))
                .andExpect(jsonPath("$[1].action").value("test2"));
    }

    @Test
    public void shouldGetToDoById() throws Exception {
        ToDo toDo = new ToDo("test1", "In progress", new Date(), 1L, ImmutableList.of(new Tag()));

        given(toDoService.getToDoById(1L)).willReturn(toDo);
        mockMvc.perform(get("/todos/{id}", 1))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.action").value("test1"));
    }

    @Test
    public void shouldReturn404IfToDoItemIsNotExist() throws Exception {
        ToDo toDo = new ToDo("test1", "In progress", new Date(), 1L, ImmutableList.of(new Tag()));

        when(toDoService.getToDoById(toDo.getId())).thenThrow(new NotFoundException());
        mockMvc.perform(get("/todos/{id}", toDo.getId()))
                .andExpect(status().isNotFound());
    }


    @Test
    public void addToDo() throws Exception {
        Tag tag = new Tag("tag");
        ToDo toDo = new ToDo("test1", "In progress", new Date(), 1L, ImmutableList.of(new Tag()));

        mockMvc.perform(
                post("/todos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(parseIntoJsonString(toDo)))
                .andExpect(status().isOk());
    }

    private String parseIntoJsonString(Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void shouldDeleteToDoById() throws Exception {
        ToDo todoNew = new ToDo("test1", "In progress", new Date(), 1L, ImmutableList.of(new Tag()));

        doNothing().when(toDoService).deleteById(todoNew.getId());

        mockMvc.perform(
                delete("/todos/{id}", todoNew.getId()))
                .andExpect(status().isOk());

        verify(toDoService, times(1)).deleteById(todoNew.getId());
        verifyNoMoreInteractions(toDoService);

    }

    @Test
    public void update() throws Exception {
        ToDo todoNew = new ToDo("test1", "In progress", new Date(), 1L, ImmutableList.of(new Tag()));

        given(toDoService.update(any(), any())).willReturn(todoNew);

        mockMvc.perform(
                put("/todos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(parseIntoJsonString(todoNew)))
                .andExpect(status().isOk());

//        verify(toDoService, times(1)).getToDoById(todoNew.getId());
        verify(toDoService, times(1)).update(todoNew.getId(), todoNew);
        verifyNoMoreInteractions(toDoService);
    }
}