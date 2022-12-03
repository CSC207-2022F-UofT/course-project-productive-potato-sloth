package useCases.Calculator.helper;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class CalculateLocalDateTime {

    /**
     * Return an int representing how many months have passed from begin to end
     * @param begin the beginning time
     * @param end the end time
     * @return the difference in months
     */
    public int month_diff(LocalDateTime begin, LocalDateTime end){
        long months = ChronoUnit.MONTHS.between(begin, end);
        return (int) months;
    }

    /**
     * Return an int representing how many days have passed from begin to end
     * @param begin the beginning time
     * @param end the end time
     * @return the differences in months
     */
    public int day_diff(LocalDateTime begin, LocalDateTime end){
        long days = ChronoUnit.DAYS.between(begin, end);
        return (int) days;
    }
    /**
     * Return an int representing how many days have passed from begin to end
     * @param begin the beginning time
     * @param end the end time
     * @return the differences in months
     */
    public int hour_diff(LocalDateTime begin, LocalDateTime end){
        long hours = ChronoUnit.HOURS.between(begin, end);
        return (int) hours;
    }
    /**
     * Return an int representing how many days have passed from begin to end
     * @param begin the beginning time
     * @param end the end time
     * @return the differences in months
     */
    public int minute_diff(LocalDateTime begin, LocalDateTime end){
        long minutes = ChronoUnit.MINUTES.between(begin, end);
        return (int) minutes;
    }

}

