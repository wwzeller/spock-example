package de.zeller.spockexample.task.service;

import de.zeller.spockexample.task.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public Task createTask(String title, String description, LocalDate dueDate) {
        if (title == null) throw new IllegalArgumentException();
        return taskRepository.save(title, description, dueDate);
    }

    public void delete(int id) {
        taskRepository.delete(id);
    }

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public List<Task> getCompletedTasks() {
        return taskRepository.findAll().stream()
                .filter(Task::isCompleted)
                .collect(Collectors.toList());
    }

    public void toggleStatus(int id) {
        taskRepository.toggleStatus(id);
    }
}
