package useCases.Timer;

import entities.Timer;
import entities.User;
import entities.TimerFactory;
import services.CurrentUserService;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * A use case interactor class which manipulates the Timer entity
 */
public class TimerInteractor implements TimerInputBoundary{

    final TimerPresenter timerPresenter;
    final TimerFactory timerFactory;
    private Duration inputDuration;

    private Timer timer;

    //constructor
    public TimerInteractor(TimerPresenter timerPresenter, TimerFactory timerFactory){

        //this.inputDuration = inputDuration;
        this.timerPresenter = timerPresenter;
        this.timerFactory = timerFactory;
    }

    @Override
    public TimerOutputData create(TimerInputData inputData) {

        inputDuration = inputData.getInputDurationOfTimer();
        Timer t = timerFactory.create(inputDuration);
        this.timer = t;
        // using the current user service to get the current user object
        CurrentUserService currentUserService = new CurrentUserService();
        User currUser = currentUserService.getCurrentUser();
        //TODO: add t to currUser timer list.


        TimerOutputData timerOutputData = new TimerOutputData(inputDuration);
        return timerPresenter.prepareSuccessView(timerOutputData);
    }
    /**
     * Creates timer object when user opens the timer window of the duration that user enters
     */

    /**
     * Stops the timer countdown and holds the duration of the timer constant till the user does not press start again
     *     Updates the remainingDuration variable in Timer Class
     */
    @Override
    public void pause(){

        timer.setRemainingDuration(LocalDateTime.now());
    }

    @Override
    public void pause(LocalDateTime restartTime) {
        timer.setRemainingDurationAfterPause(restartTime);
    }

    /**
     * When user ends the timer session, output end of session
     *     Is also automatically called when the Time on the clock runs out
     */
    void endTimer(){}

    /**
     * Starts count up timer for the break
     */
    void startBreak(){}

    /**
     * Ends the break, stop the break count up
     * Add the break duration to the instance variable of timer
     *     Calls startTimer to resume the Timer
     */
    void endBreak(){}



}
