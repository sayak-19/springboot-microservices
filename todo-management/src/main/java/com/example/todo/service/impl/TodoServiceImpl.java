package com.example.todo.service.impl;

import com.example.todo.dto.TodoDTO;
import com.example.todo.entity.Todo;
import com.example.todo.exception.ResourceNotFoundExceptiopn;
import com.example.todo.repository.TodoRepository;
import com.example.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;
    private ModelMapper modelMapper;

    @Override
    public TodoDTO addTodo(TodoDTO todoDTO) {

        //Todo todo = new Todo();
        //BeanUtils.copyProperties(todoDTO, todo);
        Todo todo = modelMapper.map(todoDTO, Todo.class);   //converting todoDTO to todo entity using Model Mapper

        Todo savedTodo = todoRepository.save(todo);

        //BeanUtils.copyProperties(savedTodo, todoDTO);
        TodoDTO savedTodoDTO = modelMapper.map(savedTodo, TodoDTO.class);
        return savedTodoDTO;
    }

    @Override
    public TodoDTO getTodo(Long id) {

        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExceptiopn("Todo not found with id:"+id));

        return modelMapper.map(todo,TodoDTO.class);
    }

    @Override
    public List<TodoDTO> getAllTodos() {

        List<Todo> todos = todoRepository.findAll();

        return todos.stream().map((todo -> modelMapper.map(todo, TodoDTO.class))).collect(Collectors.toList());
    }

    @Override
    public TodoDTO updateTodo(TodoDTO todoDTO, Long id) {

        Todo todo = todoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundExceptiopn("Todo not found with id:"+id));

        todo.setTitle(todoDTO.getTitle());
        todo.setDescription(todoDTO.getDescription());
        todo.setCompleted(todoDTO.getCompleted());

        Todo updatedTodo = todoRepository.save(todo);

        return modelMapper.map(updatedTodo, TodoDTO.class);
    }

    @Override
    public void deleteTodo(Long id) {

        Todo todo = todoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundExceptiopn("Todo not found with id:"+id));

        todoRepository.delete(todo);
    }

    @Override
    public TodoDTO completeTodo(Long id) {

        Todo todo = todoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundExceptiopn("Todo not found with id:"+id));

        todo.setCompleted(Boolean.TRUE);

        Todo updatedTodo = todoRepository.save(todo);

        return modelMapper.map(updatedTodo, TodoDTO.class);
    }
}
