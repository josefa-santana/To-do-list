package com.todolist.todolist.service;

import com.todolist.todolist.model.Task;
import com.todolist.todolist.model.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Singleton gerenciado pelo Spring
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // Adiciona uma nova tarefa
    public Task addTask(String description) {
        return taskRepository.save(new Task(description, "Em andamento"));
    }

    // Altera o status da tarefa para "Concluído"
    public Task markAsCompleted(Long id) {
        Task task = taskRepository.findById(id).orElseThrow();
        task.setStatus("Concluído");
        return taskRepository.save(task);
    }

    // Obtém todas as tarefas
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Remove uma tarefa por ID
    public void removeTask(Long id) {
        taskRepository.deleteById(id);
    }
}
