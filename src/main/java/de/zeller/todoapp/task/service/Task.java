package de.zeller.todoapp.task.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class Task {
    private Integer id;
    private String title;
    private String description;
    private boolean isCompleted;
    private LocalDate dueDate;
}
