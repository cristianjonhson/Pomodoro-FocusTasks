package cl.crisjonhson.PomodoroFocusTasks.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import cl.crisjonhson.PomodoroFocusTasks.model.PomodoroSession;
import cl.crisjonhson.PomodoroFocusTasks.model.Task;

public interface PomodoroSessionRepository extends JpaRepository<PomodoroSession, Long> {
    List<PomodoroSession> findByTask(Task task);
}
