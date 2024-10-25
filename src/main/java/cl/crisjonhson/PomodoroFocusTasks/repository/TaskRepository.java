package cl.crisjonhson.PomodoroFocusTasks.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import cl.crisjonhson.PomodoroFocusTasks.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByCompleted(boolean completed);
}
