package useCases.Calculator;

import entities.Tag;
import entities.User;

public interface CalcByTag {
    /**
     * Return the total amount of time the user had scheduled during the given time interval for tasks
     * with a given tag
     * @param user for which user we need to output the rawTime
     * @param tag the tag of the task
     * @param unit the unit of time (Day/Week/Month/Year)
     *
     */
    void timeByTag(User user, Tag tag, String unit);

    /**
     * Return the total amount of time the user had focused during the given time interval for tasks
     * with a given tag
     * @param user for which user we need to output the rawTime
     * @param tag the tag of the task
     * @param unit the unit of time (Day/Week/Month/Year)
     *
     */
    void focusByTag(User user, Tag tag, String unit);

    /**
     * Return the total amount of time the user had dedicated to tasks with a
     * given tag
     * @param user for which user we need to output the rawTime
     * @param tag the tag of the task
     * @param unit the unit of time (Day/Week/Month/Year)
     *
     */
    void allocationByTag(User user, Tag tag, String unit);

    /**
     * Return the total number of tasks with a given tag the user had completed
     * @param user for which user we need to output the rawTime
     * @param tag the tag of the task
     * @param unit the unit of time (Day/Week/Month/Year)
     *
     */
    void completionByTag(User user, Tag tag, String unit);

    /**
     * Return the total number of pauses the user had made for tasks with a given tag
     * @param user for which user we need to output the rawTime
     * @param tag the tag of the task
     * @param unit the unit of time (Day/Week/Month/Year)
     *
     */
    void pauseByTag(User user, Tag tag, String unit);
}
