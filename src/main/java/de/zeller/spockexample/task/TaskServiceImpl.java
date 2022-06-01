package de.zeller.spockexample.task;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final List<Task> tasks = new ArrayList<>();

    @Override
    public void addTask(String title, String description) {
        tasks.add(new Task(tasks.size() + 1,title, description, Status.NOT_ASSIGNED));
    }

    @Override
    public List<Task> getAll() {
        return new ArrayList<>(tasks);
    }
}
