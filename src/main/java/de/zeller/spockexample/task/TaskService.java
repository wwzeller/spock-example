package de.zeller.spockexample.task;

import java.util.List;

public interface TaskService {
    void addTask(String title, String description);
    List<Task> getAll();
}
