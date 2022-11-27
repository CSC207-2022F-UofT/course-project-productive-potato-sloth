package useCases.Timer;
import java.time.Duration;

/**
 * Input Data class which gets the data from the user via the controller
 */
public class TimerInputData {

    /**
     * Stores input data
     */
    private Duration inputDurationOfTimer;

    /**
     * Stores Input string that depends on the user’s input
     * Input string like start, pause, end
     */
    private String userCommand;

    //constructor
    /**
     * Constructs TimerInputData object given the input duration
     * @param inputDuration The duration for the Timer, how long of a Timer session do we want
     */
    TimerInputData(Duration inputDuration){
        this.inputDurationOfTimer = inputDuration;
    }

    //constructor 2
    /**
     * Constructs TimerInputData object given the input duration
     * @param inputDuration The duration for the Timer, how long of a Timer session do we want
     * @param userCommand Stores Input string that depends on the user input, Input string like start, pause, end
     */
    TimerInputData(Duration inputDuration, String userCommand){
        this.inputDurationOfTimer = inputDuration;
        this.userCommand = userCommand;
    }

    /**
     * Gets the startTime of the Timer
     * @return startTime of the Timer, LocalDateTime when the timer was started
     */
    Duration getInputDurationOfTimer(){
        return this.inputDurationOfTimer;
    }

    /**
     * Gets the startTime of the Timer
     * @return startTime of the Timer, LocalDateTime when the timer was started
     */
    String getUserCommand(){
        return this.userCommand;
    }
}
