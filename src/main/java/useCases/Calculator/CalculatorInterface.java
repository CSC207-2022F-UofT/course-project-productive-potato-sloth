package useCases.Calculator;

import entities.Event;
import entities.User;

import java.util.List;

public interface CalculatorInterface {
    /**
     * An interface for abstract class calculator. Mainly to establish the input boundary for all calculators.
     * @param user the currently logged-in user
     * @param unit the unit of time
     * @return returns the correct unit converted into a valid int that the calculators could read
     */
    int unit_reader(User user, String unit);

    /**
     * Gathers events that should be grouped togerther based on unit. For example, if the unit is Month, then
     * this program will gather all the events booked last month
     * @param user the currently logged-in user
     * @param unit the unit of time
     * @return returns the events that are correctly grouped together by unit.
     */
    List<Event> gather_events(User user, String unit);
}
