package de.zeller.spockexample.task.web;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TaskDto {
    private String title;
    private String description;
}
