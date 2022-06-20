package de.zeller.spockexample.task.web;

import de.zeller.spockexample.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping("/create")
    public String create(@ModelAttribute TaskDto taskDto) {
        taskService.createTask(taskDto.getTitle(), taskDto.getDescription(), LocalDate.parse(taskDto.getDueDate()));
        return "redirect:";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute TaskDto taskDto) {
        taskService.delete(taskDto.getId());
        return "redirect:";
    }

    @GetMapping
    public String getAll(Model model) {
        List<TaskDto> tasks = taskService.getAll().stream().map(
                        task -> new TaskDto(task.getId(),
                                task.getTitle(),
                                task.getDescription(),
                                task.getDueDate().toString(),
                                task.isCompleted())
                )
                .collect(Collectors.toList());
        model.addAttribute("tasks", tasks);
        model.addAttribute("taskDto", new TaskDto());
        return "main";
    }
}
