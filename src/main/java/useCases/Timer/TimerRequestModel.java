package useCases.Timer;

// Use case layer

import java.time.Duration;

public class TimerRequestModel {

    private Duration inputDurationOfTimer;

    public TimerRequestModel(Duration inputDuration){

        this.inputDurationOfTimer = inputDuration;
    }

    Duration getInputDurationOfTimer(){
        return this.inputDurationOfTimer;
    }

    void setInputDurationOfTimer(Duration inputDuration) {
        this.inputDurationOfTimer = inputDuration;
    }

}
