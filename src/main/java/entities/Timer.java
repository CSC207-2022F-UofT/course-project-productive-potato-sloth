package entities;

import java.io.Serializable;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * An entity class representing a Timer object
 */
public class Timer {

    /**
     * Stores starting Time of the Timer
     */
    LocalDateTime startTime;


    /**
     * Stores starting Duration of the Timer
     */
    Duration startDuration;


    /**
     * Stores remaining duration of the Timer
     */
    Duration remainingDuration;


    /**
     * Stores numOfBreaks
     */
    int numOfBreaks;


    /**
     * Stores total duration spent on breaks
     */
    Duration totalBreakTime;


    /**
     * Stores total duration spent on study
     */
    Duration totalStudyTime;


// constructor
    /**
     * Constructs a Timer given the starting duration
     * @param duration The duration for the Timer (how long of a Timer session do we want)
     */
    public Timer(Duration duration) {

        this.startDuration = duration;
        this.remainingDuration = duration;
        this.startTime = LocalDateTime.now();
        this.totalBreakTime = Duration.of(0, ChronoUnit.MINUTES);
        this.totalStudyTime = Duration.of(0, ChronoUnit.MINUTES);
        this.numOfBreaks = 0;
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
        remainingDuration = getStartDuration().minus(duration);
        if (remainingDuration.getSeconds() <= 0){
            this.remainingDuration = Duration.ofSeconds(0);
        }
        else{
            this.remainingDuration = remainingDuration;
        }
        setTotalStudyTime(duration);
    }
    /**
     * Sets the remaining duration of the Timer
     * @param restartTime the DateTime at which the Timer was restarted after being paused for a while
     */
    public void setRemainingDurationAfterPause(LocalDateTime restartTime) {
        Duration duration = Duration.between(restartTime, LocalDateTime.now());
        remainingDuration = getRemainingDuration().minus(duration);
        if (remainingDuration.getSeconds() <= 0){
            this.remainingDuration = Duration.ofSeconds(0);
        }
        else{
            this.remainingDuration = remainingDuration;
        }

        setTotalStudyTime(getTotalStudyTime().plus(duration));
    }

    /**
     * adds to the total break time of the timer the specified duration
     * @param breakTime the break duration that needs to be added to totalBreakTime
     */
    public void addToTotalBreakTime(Duration breakTime) {
        totalBreakTime = totalBreakTime.plus(breakTime);
    }

    /**
     * adds to the total study time of the timer the specified duration
     * @param studyTime the break duration that needs to be added to totalBreakTime
     */
    public void setTotalStudyTime(Duration studyTime) {
        this.totalStudyTime = studyTime;
    }

    /**
     * Increases the value of numOfBreaks by 1
     */
    public void oneUpNumOfBreaks(){
        numOfBreaks += 1;
    }

}
