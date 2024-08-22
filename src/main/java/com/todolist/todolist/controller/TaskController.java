package com.todolist.todolist.controller;

import com.todolist.todolist.model.Task;
import com.todolist.todolist.service.TaskService;
import com.todolist.todolist.strategy.TaskFilter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    private final TaskFilter taskFilter = new TaskFilter();

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // Adiciona uma nova tarefa
    @PostMapping("/add")
    public Task addTask(@RequestBody String description) {
        return taskService.addTask(description);
    }

    // Retorna todas as tarefas
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    // Marca a tarefa como concluída
    @PutMapping("/complete/{id}")
    public Task markAsCompleted(@PathVariable Long id) {
        return taskService.markAsCompleted(id);
    }

    // Remove uma tarefa
    @DeleteMapping("/remove/{id}")
    public void removeTask(@PathVariable Long id) {
        taskService.removeTask(id);
    }

    // Filtra tarefas por status
    @GetMapping("/filter/status")
    public List<Task> filterByStatus(@RequestParam String status) {
        return taskFilter.filterByStatus(taskService.getAllTasks(), status);
    }

}