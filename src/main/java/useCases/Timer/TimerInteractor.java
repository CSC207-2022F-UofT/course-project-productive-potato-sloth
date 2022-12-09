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

        this.timerPresenter = timerPresenter;
        this.timerFactory = timerFactory;
    }


    /**
     * Creates timer object and adds it current user's timer list.
     * @param inputData object that contains the input duration entered by the user.
     */
    @Override
    public TimerOutputData create(TimerInputData inputData) {

        inputDuration = inputData.getInputDurationOfTimer();
        Timer t = timerFactory.create(inputDuration);
        this.timer = t;

        // using the current user service to get the current user object
        CurrentUserService currentUserService = new CurrentUserService();
        User currUser = currentUserService.getCurrentUser();
        currUser.addTimer(t);

        TimerOutputData timerOutputData = new TimerOutputData(inputDuration);
        return timerPresenter.prepareSuccessView(timerOutputData);
    }


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
    void endTimer(){
        // have not implemented the end timer button yet, hence have not implemented this method either
        // this is for future additions to the project.
    }

    /**
     * Starts count up timer for the break
     */
    void startBreak(){
        // this is for future additions to the project.
    }

    /**
     * Ends the break, stop the break count up
     * Add the break duration to the instance variable of timer
     *     Calls startTimer to resume the Timer
     */
    void endBreak(){
        // this is for future additions to the project.
    }

}
