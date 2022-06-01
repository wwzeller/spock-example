package de.zeller.spockexample.task.web;

import de.zeller.spockexample.task.service.Task;
import de.zeller.spockexample.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping("/task")
    public ResponseEntity<Task> create(@RequestBody TaskDto task) {
        Task result = taskService.createTask(task.getTitle(), task.getDescription());

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/task/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        taskService.delete(id);

        return ResponseEntity.accepted().build();
    }

    @GetMapping("/task")
    public ResponseEntity<List<Task>> getAll() {
        return ResponseEntity.ok(taskService.getAll());
    }
}
