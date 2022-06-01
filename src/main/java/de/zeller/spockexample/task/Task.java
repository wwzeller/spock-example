package de.zeller.spockexample.task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Task {
    private int id;
    private String title;
    private String description;
    private Status status;
}
