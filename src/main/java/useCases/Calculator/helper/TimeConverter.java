package useCases.Calculator.helper;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TimeConverter {
    private final LocalDateTime today;
    private final LocalDateTime otherday;
    public TimeConverter(LocalDateTime today, LocalDateTime otherday){
        this.today = today;
        this.otherday = otherday;
    }
        /**
         * * Return a list of integers representing the duration. For example 2 days 8 hours 16 minutes 3 seconds will
         * be [0, 0, 2, 8, 16, 3]
         * Notice that first two digits are filled with 0s because duration does not have year and month
         */
        public List<Integer> Convert_Duration(Duration duration){
            List<Integer> lst = new ArrayList<Integer>();
            // first two digits are filled with 0s because duration does not have year and month
            lst.add(0);
            lst.add(0);
            int day = (int) duration.toDays();
            lst.add(day);
            int hour = (int) duration.toHours();
            lst.add(hour);
            int minute = (int) duration.toMinutes();
            lst.add(minute);
            int second = (int) duration.toSeconds();
            return lst;
        }
    /**
     * * Return a list of integers representing the duration. For example 2022/01/20  11:33:26 will
     * be [2022, 1, 20, 11, 33, 26]
     */
    public List<Integer> Convert_LocalDateTime(){
        List<Integer> lst = new ArrayList<Integer>();
        CalculateLocalDateTime calc = new CalculateLocalDateTime(this.today, this.otherday);
        lst.add(calc.year_diff());
        lst.add(calc.month_diff());
        lst.add(calc.day_diff());
        lst.add(calc.hour_diff());
        lst.add(calc.minute_diff());
        return lst;
    }

    /**
     * @param today the localdatetime of today
     * @param otherday the localdatetime of the other day to which we compare
     * @param x the int representing how many years we are counting
     * @return whether the other day is within a year from today
     */
    public boolean Within_x_Year(LocalDateTime today, LocalDateTime otherday, int x){
        CalculateLocalDateTime calc = new CalculateLocalDateTime(this.today, this.otherday);
        return calc.year_diff() <= x;
    }
    /**
     * @param x the int representing how many months we are counting
     * @return whether the other day is within x months from today
     */
    public boolean Within_x_Month(int x){
        TimeConverter conv = new TimeConverter(this.today, this.otherday);
        CalculateLocalDateTime calc = new CalculateLocalDateTime(this.today, this.otherday);
        if (conv.Within_x_Year(today, otherday, 1)){
            return calc.month_diff() <= x;
        }
        else {
            return false;
        }

    }
    /**
     * @param x the int representing how many months we are counting
     * @return whether the other day is within x months from today
     * Precondition: x must be less than 30. This method only counts the difference of days within the same month
     */
    public boolean Within_x_Days(int x){
        TimeConverter conv = new TimeConverter(this.today, this.otherday);
        CalculateLocalDateTime calc = new CalculateLocalDateTime(this.today, this.otherday);
        if (conv.Within_x_Month(1)){
            return calc.day_diff() <= x;
        }
        else {
            return false;
        }
    }
    /**
     * @param today the localdatetime of today
     * @param otherday the localdatetime of the other day to which we compare
     * @return whether the other day is within x months from today
     * This is a special case of Within_x_Days, this counts 7 days.
     */
    public boolean Within_a_Week(){
        TimeConverter conv = new TimeConverter(this.today, this.otherday);
        CalculateLocalDateTime calc = new CalculateLocalDateTime(this.today, this.otherday);
        if (conv.Within_x_Month(1)){
            return calc.day_diff() <= 7;
        }
        else {
            return false;
        }


}}
