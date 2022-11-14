package entities;

import java.time.LocalDateTime;
import java.time.Duration;

/**
 * An entity class representing a Timer object
 */
public class Timer {

    LocalDateTime startTime;
    /**
     * Stores starting Time of the Timer
     */

    Duration startDuration;
    /**
     * Stores starting Duration of the Timer
     */

    Duration remainingDuration;
    /**
     * Stores remaining duration of the Timer
     */

    int numOfBreaks;
    /**
     * Stores starting Duration of the Timer
     */

    Duration totalBreakTime;
    /**
     * Stores starting Duration of the Timer
     */

    Duration totalStudyTime;
    /**
     * Stores starting Duration of the Timer
     */

// constructor
    /**
     * Constructs a Timer given the starting duration
     * @param duration The duration for the Timer (how long of a Timer session do we want)
     */
    public Timer(Duration duration) {
        //TODO:  add it to current user's list
        // currentUserService??
        this.startDuration = duration;
        this.startTime = LocalDateTime.now();
    }

// getters
    /**
     * Gets the startTime of the Timer
     * @return startTime of the Timer (LocalDateTime when the timer was started)
     */
    public LocalDateTime getStartTime() {return this.startTime; }


    /**
     * Gets the startDuration of the Timer (Duration for which user wants to run the timer)
     * @return startDuration of the Timer
     */
    public Duration getStartDuration() {return this.startDuration; }


    /**
     * Gets the remainingDuration of the Timer (Remaining duration before the Timer runs out)
     * @return remainingDuration of the Timer
     */
    public Duration getRemainingDuration() {return this.remainingDuration; }


    /**
     * Gets the number of breaks the user took when the timer was running
     * @return numOfBreaks of the Timer
     */
    public int getNumOfBreaks() {return this.numOfBreaks; }


    /**
     * Gets the total time spent on breaks while the timer was running
     * @return totalBreakTime of the Timer
     */
    public Duration getTotalBreakTime()
    {
        return this.totalBreakTime;
    }


    /**
     * Gets the total time spent working while the timer was running
     * @return totalStudyTime of the Timer
     */
    public Duration getTotalStudyTime()
    {
        return this.totalStudyTime;
    }

// setters
    /**
     * Sets the remaining duration of the Timer
     * @param currentDateTime the current DateTime object when this method is called
     */
    public void setRemainingDuration(LocalDateTime currentDateTime) {
        Duration duration = Duration.between(this.startTime, currentDateTime);
        this.remainingDuration = duration;
    }

    /**
     * adds to the total break time of the timer the specified duration
     * @param breakTime the break duration that needs to be added to totalBreakTime
     */
    public void addToTotalBreakTime(Duration breakTime) {
        remainingDuration = remainingDuration.plus(breakTime);
    }

    /**
     * Increases the value of numOfBreaks by 1
     */
    public void oneUpNumOfBreaks(){
        numOfBreaks += 1;
    }
}
