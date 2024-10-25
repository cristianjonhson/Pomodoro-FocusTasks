package cl.crisjonhson.PomodoroFocusTasks.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cl.crisjonhson.PomodoroFocusTasks.model.PomodoroSession;
import cl.crisjonhson.PomodoroFocusTasks.model.Task;
import cl.crisjonhson.PomodoroFocusTasks.services.PomodoroService;
import cl.crisjonhson.PomodoroFocusTasks.services.TaskService;

@RestController
@RequestMapping("/pomodoro")
public class PomodoroController {

    @Autowired
    private PomodoroService pomodoroService;

    @Autowired
    private TaskService taskService;

    @PostMapping("/start/{taskId}")
    public ResponseEntity<?> startPomodoro(@PathVariable Long taskId) {
        Task task = taskService.getTaskById(taskId);
        PomodoroSession session = pomodoroService.startPomodoro(task);
        return ResponseEntity.ok(session);
    }

    @PostMapping("/end/{sessionId}")
    public ResponseEntity<?> endPomodoro(@PathVariable Long sessionId) {
        pomodoroService.endPomodoro(sessionId);
        return ResponseEntity.ok().build();
    }
}
