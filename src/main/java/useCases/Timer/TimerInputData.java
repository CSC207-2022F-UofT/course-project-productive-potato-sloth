package useCases.Timer;

// Use case layer

import java.time.Duration;

public class TimerInputData {

    private Duration inputDurationOfTimer;

    public TimerInputData(Duration inputDuration){

        this.inputDurationOfTimer = inputDuration;
    }

    Duration getInputDurationOfTimer(){
        return this.inputDurationOfTimer;
    }

    void setInputDurationOfTimer(Duration inputDuration) {
        this.inputDurationOfTimer = inputDuration;
    }

}
