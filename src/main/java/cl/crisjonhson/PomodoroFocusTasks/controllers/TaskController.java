package cl.crisjonhson.PomodoroFocusTasks.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import cl.crisjonhson.PomodoroFocusTasks.model.Task;
import cl.crisjonhson.PomodoroFocusTasks.services.TaskService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public String getAllTasks(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        model.addAttribute("task", new Task()); // Add this line
        return "task-list";
    }

    @PostMapping
    public String createTask(@Valid @ModelAttribute Task task, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("tasks", taskService.getAllTasks());
            return "task-list"; // Retorna a la vista si hay errores de validación
        }
        System.out.println("Tarea a guardar: " + task); // Debug
        taskService.saveTask(task); // Aquí se debería realizar el insert
        return "redirect:/tasks"; // Redirecciona para mostrar la lista actualizada
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
