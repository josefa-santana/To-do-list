package com.todolist.todolist.strategy;

import com.todolist.todolist.model.Task;

import java.util.List;
import java.util.stream.Collectors;

public class TaskFilter {
    // Filtra tarefas por status
    public List<Task> filterByStatus(List<Task> tasks, String status) {
        return tasks.stream()
                .filter(task -> task.getStatus().equalsIgnoreCase(status))
                .collect(Collectors.toList());
    }
}
