package de.zeller.spockexample.task.repository;

import de.zeller.spockexample.task.service.Task;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;

@Component
public class TaskRepository {
    private final List<Task> tasks = new ArrayList<>();

    public Task createNewTask(String title, String description, LocalDate dueDate) {
        int id = generateId();
        Task task = new Task(id, title, description, false, dueDate);
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

    public void switchCompleted(int id) {
        findById(id)
                .ifPresent(task -> task.setCompleted(!task.isCompleted()));
    }


    private int generateId() {
        return tasks.isEmpty() ? 1 :
                Collections.max(tasks, Comparator.comparingInt(Task::getId)).getId() + 1;
    }
}
