package useCases.Calculator;

import entities.Event;
import entities.User;

import java.util.List;

abstract class Calculator {
     // should I include a default constructor?

    /**
     * Return the total amount of time the user had scheduled during the given time interval
     * @param user for which user we need to output the rawTime
     * @param unit the unit of time (Day/Week/Month/Year)
     *
     */
    abstract int rawTime(User user, String unit);
    // SOMETHING SUPER IMPORTANT!!!
    //make sure to have a controller that could translate things like Day/Week/Month/Year to the actual arguments
    // passed to usecases
    /**
     * Return then total amount of time the user had been focused during the given time interval
     * @param user for which user we need to output the rawTime
     * @param unit the unit of time (Day/Week/Month/Year)
     *
     */
    abstract int focusedTime(User user, String unit);

    /**
     * Return the number of events marked as completed during the given time interval
     * @param user for which user we need to output the rawTime
     * @param unit the unit of time (Day/Week/Month/Year)
     *
     */
    abstract int numberOfCompletion(User user, String unit);

    /**
     * Return a list of events that are marked as completed during the given time interval
     * @param user for which user we need to output the rawTime
     * @param unit the unit of time (Day/Week/Month/Year)
     *
     */
    abstract Event[] eventsCompletion(User user, String unit);
    // make this a public method later.

    /**
     * Return the total duration of pauses the user has made during the given time interval
     * @param user for which user we need to output the rawTime
     * @param unit the unit of time (Day/Week/Month/Year)
     *
     */
    abstract double pauseTime(User user, String unit);









}
