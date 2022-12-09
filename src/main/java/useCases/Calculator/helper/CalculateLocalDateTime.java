package useCases.Calculator.helper;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class CalculateLocalDateTime {
    private final LocalDateTime today;
    private final LocalDateTime otherday;

    public CalculateLocalDateTime(LocalDateTime today, LocalDateTime otherday){
        this.today = today;
        this.otherday = otherday;
    }

    /**
     * Return an int representing how many days have passed from today to otherday
     * @return the differences in years
     */
    public int year_diff(){
        long years = ChronoUnit.YEARS.between(this.today, this.otherday);
        return (int) years;
    }
    /**
     * Return an int representing how many months have passed from begin to end
     * @return the difference in months
     */
    public int month_diff(){
        long months = ChronoUnit.MONTHS.between(this.today, this.otherday);
        return (int) months;
    }

    /**
     * Return an int representing how many days have passed from today to otherday
     * @return the differences in days
     */
    public int day_diff(){
        long days = ChronoUnit.DAYS.between(this.today, this.otherday);
        return (int) days;
    }
    /**
     * Return an int representing how many hours have passed from today to otherday
     * @return the differences in hours
     */
    public int hour_diff(){
        long hours = ChronoUnit.HOURS.between(this.today, this.otherday);
        return (int) hours;
    }
    /**
     * Return an int representing how many minutes have passed from today to otherday
     * @return the differences in minutes
     */
    public int minute_diff(){
        long minutes = ChronoUnit.MINUTES.between(this.today, this.otherday);
        return (int) minutes;
    }


}

