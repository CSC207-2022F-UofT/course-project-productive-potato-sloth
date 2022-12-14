package screens.Timer;

import useCases.Timer.TimerInputBoundary;
import useCases.Timer.TimerOutputData;
//import useCases.Timer.TimerOutputData;
import useCases.Timer.TimerInputData;
import java.time.LocalDateTime;


import java.time.Duration;

// Controller layer

public class TimerController {

    final TimerInputBoundary timerInput;

    public TimerController(TimerInputBoundary timerInput) {

        this.timerInput = timerInput;
    }

    TimerOutputData create(Duration timerDuration) {

        TimerInputData inputData = new TimerInputData(timerDuration);
        return timerInput.create(inputData);
    }

    void pause(){
        timerInput.pause();
    }
    void pause(LocalDateTime restartTime){
        timerInput.pause(restartTime);
    }
}
