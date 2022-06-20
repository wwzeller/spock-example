package de.zeller.spockexample.task.web;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private int id;
    private String title;
    private String description;
    private String dueDate;
    private boolean isCompleted;
}
