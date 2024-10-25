package cl.crisjonhson.PomodoroFocusTasks.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import cl.crisjonhson.PomodoroFocusTasks.model.Task;
import cl.crisjonhson.PomodoroFocusTasks.services.TaskService;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public String getAllTasks(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "task-list";
    }

    @PostMapping
    public String createTask(@ModelAttribute Task task) {
        taskService.saveTask(task);
        return "redirect:/tasks";
    }

    @PostMapping("/{id}/complete")
    public String completeTask(@PathVariable Long id) {
        taskService.markTaskAsCompleted(id);
        return "redirect:/tasks";
    }

    @PostMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }
}

