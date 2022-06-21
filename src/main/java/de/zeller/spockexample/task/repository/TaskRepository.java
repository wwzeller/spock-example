package de.zeller.spockexample.task.repository;

import de.zeller.spockexample.task.service.Task;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class TaskRepository {
    private final List<Task> tasks = new ArrayList<>();

    public Task save(String title, String description, LocalDate dueDate) {
        Task task = new Task(tasks.size() + 1,
                title,
                description,
                false,
                dueDate);
        tasks.add(task);

        return task;
    }

    public List<Task> findAll() {
        return new ArrayList<>(tasks);
    }

    public Optional<Task> findById(int id) {
        return findTaskById(id);
    }

    public void delete(int id) {
        tasks.removeIf(task -> task.getId() == id);
    }

    public void deleteAll() {
        tasks.clear();
    }

    public void switchCompleted(int id) {
        findTaskById(id)
                .ifPresent(task -> task.setCompleted(!task.isCompleted()));
    }

    private Optional<Task> findTaskById(int id) {
        return tasks.stream()
                .filter(task -> task.getId() == id)
                .findFirst();
    }
}
