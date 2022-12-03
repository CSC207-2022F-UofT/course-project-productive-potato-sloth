package useCases.Calculator;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Try {
    public static void main(String[] args) {
        LocalDateTime toDateTime = LocalDateTime.of(2014, 9, 16, 7, 40, 55);
        LocalDateTime fromDateTime = LocalDateTime.of(2014, 9, 16, 7, 45, 55);
        long minutes = ChronoUnit.MINUTES.between(fromDateTime, toDateTime);
        System.out.println(minutes);
        System.out.println("The result is");
    }
}
