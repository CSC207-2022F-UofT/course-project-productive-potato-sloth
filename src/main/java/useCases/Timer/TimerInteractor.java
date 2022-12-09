package useCases.Timer;

import entities.Timer;

import java.time.Duration;

/**
 * A use case interactor class which manipulates the Timer entity
 */
public class TimerInteractor {

    //private Timer timer
    // isn't this dependency on entities? Is this allowed?
    //shoule we import entities pacakage here?
    //how does this interactor know which timer entity is it working on?

    /**
     * Stores input duration
     */
    private Duration inputDuration;

    //constructor

    /**
     * Constructs TimerInputData object given the input duration
     *
     * @param inputDuration The duration for the Timer (how long of a Timer session do we want)
     */
    TimerInteractor(Duration inputDuration) {
        this.inputDuration = inputDuration;
    }


    /**
     * Creates timer object when user opens the timer window of the duration that user enters
     */
    void createTimer() {
        Timer t1 = new Timer(inputDuration);

    }

    /**
     * Starts the countdown when user presses start
     */
    void startTimer() {

    }

    /**
     * Stops the timer countdown and holds the duration of the timer constant till the user doesn’t press start again
     * Updates the remainingDuration variable in Timer Class
     */
    void pauseTimer() {
    }

    /**
     * When user ends the timer session, output "end of session"
     * Is also automatically called when the Time on the clock runs out
     */
    void endTimer() {
    }

    /**
     * Starts count up timer for the break
     */
    void startBreak() {
    }

    /**
     * Ends the break (stop the break count up)
     * Add the break duration to the instance variable of timer
     * Calls startTimer to resume the Timer
     */
    void endBreak() {
    }


}
