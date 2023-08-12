package com.example.todo.controller;

import com.example.todo.dto.TodoDTO;
import com.example.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todos")
@AllArgsConstructor
public class TodoController {

    private TodoService todoService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<TodoDTO> addTodo(@RequestBody TodoDTO todoDTO){

        TodoDTO savedTodoDTO = todoService.addTodo(todoDTO);

        return new ResponseEntity<>(savedTodoDTO, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("{id}")
    public ResponseEntity<TodoDTO> getTodo(@PathVariable("id") Long todoId){

        TodoDTO todoDTO = todoService.getTodo(todoId);

        return new ResponseEntity<>(todoDTO, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping
    public ResponseEntity<List<TodoDTO>> getAllTodos(){

        List<TodoDTO> todos = todoService.getAllTodos();

        //return new ResponseEntity<>(todos, HttpStatus.OK);
        return ResponseEntity.ok(todos);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("{id}")
    public ResponseEntity<TodoDTO> updateTodo(@RequestBody TodoDTO todoDTO, @PathVariable(value = "id") Long todoId){

        todoDTO = todoService.updateTodo(todoDTO, todoId);

        return new ResponseEntity<>(todoDTO, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable(value = "id") Long todoId){

        todoService.deleteTodo(todoId);

        return new ResponseEntity<>("Todo deleted Successfully!",HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PatchMapping("{id}/completed")
    public ResponseEntity<TodoDTO> completedTodo(@PathVariable(value = "id") Long todoId){

        TodoDTO todoDTO = todoService.completeTodo(todoId);

        return new ResponseEntity<>(todoDTO,HttpStatus.OK);
    }

}
