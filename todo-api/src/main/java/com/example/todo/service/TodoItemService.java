package com.example.todo.service;

import com.example.todo.model.TodoItem;
import com.example.todo.repository.TodoItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoItemService {

    private final TodoItemRepository repository;

    public TodoItemService(TodoItemRepository repository) {
        this.repository = repository;
    }

    public List<TodoItem> findAll() {
        return repository.findAll();
    }

    public Optional<TodoItem> findById(Long id) {
        return repository.findById(id);
    }

    public TodoItem save(TodoItem item) {
        return repository.save(item);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
