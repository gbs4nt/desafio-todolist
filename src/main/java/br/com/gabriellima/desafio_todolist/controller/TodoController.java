package br.com.gabriellima.desafio_todolist.controller;

import br.com.gabriellima.desafio_todolist.entity.Todo;
import br.com.gabriellima.desafio_todolist.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }
    @PostMapping //Anotation @Valid faz com que esse ToDo passe por uma validação
    public List<Todo> create(@RequestBody @Valid Todo todo){
    return todoService.create(todo);
    }
    @GetMapping
    public List<Todo> list(){
        return todoService.list();
    }
    @PutMapping
    public List<Todo> update(@RequestBody Todo todo){
        return todoService.update(todo);
    }
    @DeleteMapping("/delete/{id}")
    public List<Todo> delete(@PathVariable Long id){
        return todoService.delete(id);
    }

}
