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
    private final int YEAR = 0;
    private final int MONTH = 1;
    private final int DAY = 2;

    /**
     * Return the total amount of time the user had scheduled during the given time interval
     * @param unit the unit of time (Day/Week/Month/Year)
     * Precondition: unit must be "month"/"week"/"day". Other strings are not considered as valid units.
     *
     */
    private int unit_reader(String unit) {
        if (Objects.equals(unit, "Month")) {
            return MONTH;
        } else if (Objects.equals(unit, "day")) {
            return DAY;
        }
        else{
            return 99;
        }
    }

    /**
     * Return a list of events that fits the criterion
     * @param user the User entity worked with
     * @param unit the time interval of interest
     * @return a list of events stored in user that is unit amount of time away from today.
     */
    private List<Event> gather_events(User user, String unit){
        LocalDateTime today = LocalDateTime.now();
        List<Event> events = user.getEvents();
        int interval = new TotCalculator().unit_reader(unit);
        List<Event> acc = new ArrayList<Event>();
        // gather the events that are <interval> amount of time away from today.
        for (Event event: events) {
            TimeConverter conv = new TimeConverter(today, event.getEndTime());
            if (unit.equals("Month") && (conv.Within_x_Month(1))){
                acc.add(event);
            }
            if (unit.equals("Week") && (conv.Within_a_Week())) {
                acc.add(event);
            }
            if ((unit.equals("Day")) && (conv.Within_x_Days(1))){
                acc.add(event);
            }
        }
        return acc;
    }


    /**
     * Return the total amount of time the user had scheduled during the given time interval
     * @param user the user we examine
     * @param unit the unit of time (Day/Week/Month/Year)
     * Precondition: unit must be "month"/"week"/"day". Other strings are not considered as valid units.
     *
     */
    public int rawTime(User user, String unit) {
        LocalDateTime today = LocalDateTime.now();
        TotCalculator calc = new TotCalculator();
        List<Event> events = calc.gather_events(user, unit);
        int acc = 0;
        for (Event event : events) {
            CalculateLocalDateTime c = new CalculateLocalDateTime(event.getStartTime(), event.getEndTime());
            int diff = 0;
            diff = diff + c.day_diff();
            acc += diff;
        }
        return acc;
    }

    // SOMETHING SUPER IMPORTANT!!!
    //make sure to have a controller that could translate things like Day/Week/Month/Year to the actual arguments
    // passed to usecases
    /**
     * Return then total amount of time the user had been focused during the given time interval
     * @param user for which user we need to output the rawTime
     * @param unit the unit of time (Day/Week/Month/Year)
     *
     */

    /**
     *
     * @param user for which user we need to output the rawTime
     * @param unit the unit of time (Day/Week/Month/Year)
     * @return
     */
    public int focusedTime(User user, String unit){
        TotCalculator t = new TotCalculator();
        int raw = t.rawTime(user, unit);
        LocalDateTime today = LocalDateTime.now();
        TotCalculator calc = new TotCalculator();
        List<Event> events = calc.gather_events(user, unit);
        return raw/events.size();
    }

    /**
     * Return the number of events marked as completed during the given time interval
     * @param user for which user we need to output the rawTime
     * @param unit the unit of time (Day/Week/Month/Year)
     *
     */
    public int numberOfCompletion(User user, String unit){
        LocalDateTime today = LocalDateTime.now();
        TotCalculator calc = new TotCalculator();
        List<Event> events = calc.gather_events(user, unit);
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
        LocalDateTime today = LocalDateTime.now();
        TotCalculator calc = new TotCalculator();
        List<Event> events = calc.gather_events(user, unit);
        ArrayList<Task> lst = new ArrayList<Task>();
        for (Event event: events){
            Task task = event.getTask();
            if (task.getCompleted()){
                lst.add(task);
            }
        }
        return lst;


    }
    // abstract double pauseTime(User user, String unit);
}
