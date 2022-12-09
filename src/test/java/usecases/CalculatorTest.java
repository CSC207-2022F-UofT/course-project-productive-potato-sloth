package usecases;

import entities.Tag;
import entities.User;
import entities.Event;
import entities.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import useCases.Calculator.TotCalculator;


import java.awt.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    Tag tag;
    User user;
    Task task;

    @BeforeEach
    public void setup() {
        this.user = new User("testUsername", "testPassword");
        this.tag = new Tag("tag", Color.RED, this.user);
        LocalDateTime later1 = LocalDateTime.of(2022, 12, 8, 17, 0, 0);
        LocalDateTime before1 = LocalDateTime.of(2022, 12, 7, 10, 0, 0, 0);
        LocalDateTime later2 = LocalDateTime.of(2022, 12, 3, 17, 0, 0);
        LocalDateTime before2 = LocalDateTime.of(2022, 12, 1, 17, 0, 0);
        List<Tag> tags = new ArrayList<Tag>();
        tags.add(this.tag);
        Event e1 = new Event(before1, later1, this.task, "Testing1", tags);
        Event e2 = new Event(before2, later2, this.task, "Testing2", tags);
        this.user.addEvent(e1);
        this.user.addEvent(e2);
    }

    /**
     * Test what is the raw time booked before and later.
     */
    @Test public void testrawtime(){
            TotCalculator calc = new TotCalculator();
            int actual = calc.rawTime(this.user, "Day");
            int expected = 1;
            Assertions.assertEquals(expected, actual);
    }
    @Test public void test_completion(){
        TotCalculator calc = new TotCalculator();
        int actual = calc.numberOfCompletion(this.user, "Day");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }


}
