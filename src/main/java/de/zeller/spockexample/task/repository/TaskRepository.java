package de.zeller.spockexample.task.repository;

import de.zeller.spockexample.task.service.Status;
import de.zeller.spockexample.task.service.Task;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Component
public class TaskRepository {
    private final List<Task> tasks = new ArrayList<>();

    public Task save(String title, String description) {
        Task task = new Task(tasks.size() + 1, title, description, Status.NOT_ASSIGNED);
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

    public void deleteAll(){
        tasks.clear();
    }
}
