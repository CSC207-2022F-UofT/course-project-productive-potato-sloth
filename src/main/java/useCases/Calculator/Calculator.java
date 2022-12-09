package useCases.Calculator;

import entities.Event;
import entities.User;
import useCases.Calculator.helper.TimeConverter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

abstract class Calculator {
    private final int YEAR = 0;
    private final int MONTH = 1;
    private final int DAY = 2;
    public Calculator(){}
    /**
     * Convert the string representing the unit of time passed in from the controller. For example, "Month" will
     * bre converted to MONTH, which is 1.
     * @param unit the unit of time (Day/Week/Month/Year)
     * Precondition: unit must be "Month"/"Week"/"Day". Other strings are not considered as valid units.
     * This private method is created to ensure that all calculators read inputs in the exact same way.
     */
     public int unit_reader(String unit) {
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
    public List<Event> gather_events(User user, String unit){
        LocalDateTime today = LocalDateTime.now();
        List<Event> events = user.getEvents();
        int interval = this.unit_reader(unit);
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
}
