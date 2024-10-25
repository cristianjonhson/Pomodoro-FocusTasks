package cl.crisjonhson.PomodoroFocusTasks.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.crisjonhson.PomodoroFocusTasks.model.PomodoroSession;
import cl.crisjonhson.PomodoroFocusTasks.model.Task;
import cl.crisjonhson.PomodoroFocusTasks.repository.PomodoroSessionRepository;

@Service
public class PomodoroService {
    @Autowired
    private PomodoroSessionRepository pomodoroSessionRepository;

    public PomodoroSession startPomodoro(Task task) {
        PomodoroSession session = new PomodoroSession();
        session.setTask(task);
        session.setStartTime(LocalDateTime.now());
        return pomodoroSessionRepository.save(session);
    }

    public void endPomodoro(Long sessionId) {
        PomodoroSession session = pomodoroSessionRepository.findById(sessionId).orElseThrow();
        session.setEndTime(LocalDateTime.now());
        pomodoroSessionRepository.save(session);
    }
}