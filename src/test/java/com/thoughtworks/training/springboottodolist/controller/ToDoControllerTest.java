package com.thoughtworks.training.springboottodolist.controller;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class ToDoControllerTest {

//    @Autowired
//    private MockMvc mockMvc;

//    @MockBean
//    private ToDoService toDoService;

//    @Test
//    public void shouldGetAllToDoItems() throws Exception {
//        ToDo toDo = new ToDo(1L, "test1", "In progress", new Date(), tagsId);
//        ToDo toDo1 = new ToDo(2L, "test2", "To Do", new Date(), tagsId);
//
//        List<ToDo> toDoList = Arrays.asList(toDo, toDo1);
//
//        given(toDoService.getToDoList()).willReturn(toDoList);
//
//        mockMvc.perform(get("/todos"))
//                .andExpect(status().is(200))
//                .andExpect(jsonPath("$", hasSize(2)))
//                .andExpect(jsonPath("$[0].action").value("test1"))
//                .andExpect(jsonPath("$[1].action").value("test2"));
//    }
//
//    @Test
//    public void shouldGetToDoById() throws Exception {
//        ToDo toDo = new ToDo(1L, "test1", "In progress", new Date(), tagsId);
//
//        given(toDoService.getToDoById(1L)).willReturn(toDo);
//        mockMvc.perform(get("/todos/{id}", 1))
//                .andExpect(status().is(200))
//                .andExpect(jsonPath("$.id").value("1"))
//                .andExpect(jsonPath("$.action").value("test1"));
//    }
//
//    @Test
//    public void shouldReturn404IfToDoItemIsNotExist() throws Exception {
//        ToDo toDo = new ToDo(100L, "test1", "In progress", new Date(), tagsId);
//        when(toDoService.getToDoById(toDo.getId())).thenThrow(new NotFoundException());
//        mockMvc.perform(get("/todos/{id}", toDo.getId()))
//                .andExpect(status().isNotFound());
//    }


//    @Test
//    public void addToDo() throws Exception {
//        Tag tag = new Tag("tag");
//        ToDo toDo = new ToDo("test1", "In progress", new Date(), ImmutableList.of(tag));
//        mockMvc.perform(
//                post("/todos")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(parseIntoJsonString(toDo)))
//                .andExpect(status().isOk());
//    }
//
//    private String parseIntoJsonString(Object obj) {
//        try {
//            return new ObjectMapper().writeValueAsString(obj);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }

//    @Test
//    public void shouldDeleteToDoById() throws Exception {
//        ToDo todoNew = new ToDo(1L, "todoNew", "to do", new Date(), tagsId);
//
//        doNothing().when(toDoService).deleteById(todoNew.getId());
//
//        mockMvc.perform(
//                delete("/todos/{id}", todoNew.getId()))
//                .andExpect(status().isOk());
//
//        verify(toDoService, times(1)).deleteById(todoNew.getId());
//        verifyNoMoreInteractions(toDoService);
//
//    }
//
//    @Test
//    public void update() throws Exception {
//        ToDo todoNew = new ToDo(1L, "todoNew", "to do", new Date(), tagsId);
//
//        given(toDoService.update(any(), any())).willReturn(todoNew);
//
//        mockMvc.perform(
//                put("/todos")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(parseIntoJsonString(todoNew)))
//                .andExpect(status().isOk());
//
////        verify(toDoService, times(1)).getToDoById(todoNew.getId());
//        verify(toDoService, times(1)).update(todoNew.getId(), todoNew);
//        verifyNoMoreInteractions(toDoService);
//    }
}