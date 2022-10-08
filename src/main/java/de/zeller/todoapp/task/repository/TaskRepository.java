package de.zeller.todoapp.task.repository;

import de.zeller.todoapp.task.service.Task;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;

@Component
public class TaskRepository {
    private final List<Task> tasks = new ArrayList<>();

    public Task save(String title, String description, LocalDate dueDate) {
        if (title == null) {
            throw new IllegalArgumentException("title should not be null");
        }
        title = title.trim();
        if (title.isBlank() || title.length() < 3) {
            throw new IllegalArgumentException("title length should be at least 3 characters");
        }
        Task task = new Task(generateId(), title, description, false, dueDate);
        tasks.add(task);
        return task;
    }

    public List<Task> findAll() {
        return new ArrayList<>(tasks);
    }

    public Optional<Task> findById(int id) {
        return tasks.stream()
                .filter(task -> task.getId() == id)
                .findFirst();
    }

    public void delete(int id) {
        tasks.removeIf(task -> task.getId() == id);
    }

    public void deleteAll() {
        tasks.clear();
    }

    public void toggleStatus(int id) {
        findById(id).ifPresent(task -> task.setCompleted(!task.isCompleted()));
    }

    private int generateId() {
        return tasks.isEmpty() ? 1 :
                Collections.max(tasks, Comparator.comparingInt(Task::getId)).getId() + 1;
    }
}
