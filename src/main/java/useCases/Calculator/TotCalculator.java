package useCases.Calculator;

import entities.Event;
import entities.Task;
import entities.User;
import useCases.Calculator.helper.CalculateLocalDateTime;
import useCases.Calculator.helper.TimeConverter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TotCalculator extends Calculator{
    public TotCalculator(){}

    /**
     * Return the total amount of time the user had scheduled during the given time interval
     * @param user the user we examine
     * @param unit the unit of time (Day/Week/Month/Year)
     * Precondition: unit must be "month"/"week"/"day". Other strings are not considered as valid units.
     *
     */
    public int rawTime(User user, String unit) {
        List<Event> events = super.gather_events(user, unit);
        int acc = 0;
        for (Event event : events) {
            CalculateLocalDateTime c = new CalculateLocalDateTime(event.getStartTime(), event.getEndTime());
            int diff = 0;
            diff = diff + c.day_diff();
            acc += diff;
        }
        return acc;
    }

    public int focusedTime(User user, String unit){
        TotCalculator t = new TotCalculator();
        int raw = t.rawTime(user, unit);
        List<Event> events = super.gather_events(user, unit);
        return raw/events.size();
    }

    /**
     * Return the number of events marked as completed during the given time interval
     * @param user for which user we need to output the rawTime
     * @param unit the unit of time (Day/Week/Month/Year)
     *
     */
    public int numberOfCompletion(User user, String unit){
        List<Event> events = super.gather_events(user, unit);
        int acc = 0;
        for (Event event: events){
            Task task = event.getTask();
            if (task.getCompleted()){
                acc += 1;
            }
        }
        return acc;

    }

    /**
     * Return a list of events that are marked as completed during the given time interval
     * @param user for which user we need to output the rawTime
     * @param unit the unit of time (Day/Week/Month/Year)
     *
     */
    public ArrayList<Task> eventsCompletion(User user, String unit){
        List<Event> events = super.gather_events(user, unit);
        ArrayList<Task> lst = new ArrayList<Task>();
        for (Event event: events){
            Task task = event.getTask();
            if (task.getCompleted()){
                lst.add(task);
            }
        }
        return lst;


    }}
