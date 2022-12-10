package useCases.Timer;

// Use case layer

import java.time.LocalDateTime;

public interface TimerInputBoundary {
    TimerOutputData create(TimerInputData inputData);
    void pause();
    void pause(LocalDateTime startTime);
}
