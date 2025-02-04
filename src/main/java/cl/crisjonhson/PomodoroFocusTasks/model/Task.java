package cl.crisjonhson.PomodoroFocusTasks.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "no debe estar vacío") 
    private String title;
    
    private String description;
    
    private boolean completed;
    
    private int pomodoroSessions; // Número de sesiones pomodoro completadas

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
