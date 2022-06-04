package de.zeller.spockexample.task.web;

import de.zeller.spockexample.task.service.Task;
import de.zeller.spockexample.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping("/create")
    public String create(@ModelAttribute TaskDto taskDto) {
        taskService.createTask(taskDto.getTitle(), taskDto.getDescription());
        return "redirect:";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute TaskDto taskDto) {
        taskService.delete(taskDto.getId());
        return "redirect:";
    }

    @GetMapping
    public String getAll(Model model) {
        List<Task> tasks = taskService.getAll();
        model.addAttribute("tasks", tasks);
        model.addAttribute("taskDto", new TaskDto());
        return "main";
    }
}
