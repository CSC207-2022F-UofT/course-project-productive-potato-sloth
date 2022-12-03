package useCases.Timer;

// Use case layer

import java.time.Duration;

public class TimerOutputData {

    Duration durationOfTimer;
    //String creationTime;

    public TimerOutputData(Duration durationOfTimer) {
        this.durationOfTimer = durationOfTimer;
        //this.creationTime = creationTime;
    }

    public Duration getDurationOfTimer() {
        return durationOfTimer;
    }

    public void setDurationOfTimer(Duration durationOfTimer) {
        this.durationOfTimer = durationOfTimer;
    }

}
