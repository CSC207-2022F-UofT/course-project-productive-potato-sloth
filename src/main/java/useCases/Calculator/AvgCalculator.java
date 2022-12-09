package useCases.Calculator;

import entities.Tag;
import entities.Task;
import entities.User;

import java.util.ArrayList;
import java.util.List;

public class AvgCalculator extends Calculator implements CalcByTag{

    // Please note that all averages here are taken naively. In other words, we are only considering the
    // case where the use wants to look at the average of what happened last week.
    // We realized that responding to customized parameters the user give creates too much
    // work and is not appropriate for the scale of the project.

    /**
     * @param user for which user we need to output the rawTime
     * @param unit the unit of time (Day/Week/Month/Year)
     * @return Return the average time the user had booked for himself last week
     */
    public int rawTime(User user, String unit) {
        TotCalculator calc = new TotCalculator();
        int raw = calc.rawTime(user, unit);
        return raw/7;

    }
    /**
     * @param user for which user we need to output the rawTime
     * @param unit the unit of time (Day/Week/Month/Year)
     * @return Return the average number of completions the user had made for himself last week
     */
    public int numberOfCompletion(User user, String unit){
        TotCalculator calc = new TotCalculator();
        int number = calc.numberOfCompletion(user, unit);
        return number/7;
    }

    /**
     * @param user for which user we need to output the rawTime
     * @param unit the unit of time (Day/Week/Month/Year)
     * @return Return the average number of completions the user had booked for himself last week
     * by tag
     */
    public int rawTimeByTag(User user, String unit, Tag tag){
        TotCalculator calc = new TotCalculator();
        int raw = calc.rawTimeByTag(user, unit, tag);
        return raw/7;
    }
    public int completionByTag(User user, String unit, Tag tag){
        TotCalculator calc = new TotCalculator();
        int number = calc.completionByTag(user, unit, tag);
        return number/7;
    }

}
