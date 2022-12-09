package screens.Timer;

import useCases.Timer.TimerInputBoundary;
import useCases.Timer.TimerOutputData;
//import useCases.Timer.TimerOutputData;
import useCases.Timer.TimerInputData;


import java.time.Duration;

// Interface adapters layer

public class TimerController {

    final TimerInputBoundary timerInput;

    public TimerController(TimerInputBoundary timerInput) {

        this.timerInput = timerInput;
    }

    TimerOutputData create(Duration timerDuration) {
        TimerInputData inputData = new TimerInputData(timerDuration);

        return timerInput.create(inputData);
    }
}
