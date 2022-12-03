package useCases.Calculator.helper;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TimeConverter {
        /**
         * * Return a list of integers representing the duration. For example 2 days 8 hours 16 minutes 3 seconds will
         * be [0, 0, 2, 8, 16, 3]
         * Notice that first two digits are filled with 0s because duration does not have year and month
         */
        List<Integer> Convert_Duration(Duration duration){
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
    List<Integer> Convert_LocalDateTime(LocalDateTime localdatetime){
        List<Integer> lst = new ArrayList<Integer>();
        // first two digits are filled with 0s because duration does not have year and month
        int year = (int) localdatetime.getYear();
        lst.add(year);
        int month = (int) localdatetime.getMonthValue();
        lst.add(month);
        int day = (int) localdatetime.getDayOfMonth();
        lst.add(day);
        int hour = (int) localdatetime.getHour();
        lst.add(hour);
        int minute = (int) localdatetime.getMinute();
        lst.add(minute);
        int second = (int) localdatetime.getSecond();
        return lst;
    }
    /**
     Calculate the difference in minutes and hour
     */
    int cal_min(int begin, int end){
        if (begin < end){
            return end - begin;
        }
        else{
            end += 60;
            return end - begin;
        }
    }
    int cal_hour(int begin, int end){
        if (begin < end){
            return end - begin;
        }
        else{
            return 1;

        }
    }

}
