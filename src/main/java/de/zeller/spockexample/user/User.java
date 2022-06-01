package de.zeller.spockexample.user;

import de.zeller.spockexample.task.service.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private List<Task> tasks;
}
