package usecases;

import entities.Tag;
import entities.Task;
import entities.User;
import entities.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import useCases.Calculator.TotCalculator;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CalculatorTest {
    Tag tag;
    User user;
    Task task;

    @BeforeEach
    public void setup() {
        this.user = new User("testUsername", "testPassword");
        this.tag = new Tag("tag", Color.RED, this.user);
        Tag tag2 = new Tag("Tag2", Color.RED, this.user);
        Task task1 = new Task("Task1", this.user, "");
        Task task2 = new Task("Task2", this.user, "");
        this.task = task1;
        LocalDateTime later1 = LocalDateTime.of(2022, 12, 8, 17, 0, 0);
        LocalDateTime before1 = LocalDateTime.of(2022, 12, 7, 10, 0, 0, 0);
        LocalDateTime later2 = LocalDateTime.of(2022, 12, 3, 17, 0, 0);
        LocalDateTime before2 = LocalDateTime.of(2022, 12, 1, 17, 0, 0);
        List<Tag> tags = new ArrayList<Tag>();
        Event e1 = new Event(before1, later1, task1, "Testing1", tags);
        Event e2 = new Event(before2, later2, task2, "Testing2", tags);
        e1.addTag(this.tag);
        e2.addTag(tag2);
        this.user.addTask(task1);
        this.user.addTask(task2);
        this.user.addEvent(e1);
        this.user.addEvent(e2);
    }

    /**
     * Test what is the raw time booked before and later.
     */
    @Test public void testrawtime(){
        TotCalculator calc = new TotCalculator();
        int actual = calc.rawTime(this.user, "Day");
        int expected = 79;
        Assertions.assertEquals(expected, actual);
    }
    /**
     * Test how many events have been marked as completed
     */
    @Test public void test_completion(){
        TotCalculator calc = new TotCalculator();
        int actual = calc.numberOfCompletion(this.user, "Day");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }
    /**
     * Test how much time the user had spend last week on tasks with certain tags.
     */
    @Test public void test_rawTimeByTag(){
        TotCalculator calc = new TotCalculator();
        int actual = calc.rawTimeByTag(this.user, "Day", this.tag);
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test public void test_completionByTag(){
        TotCalculator calc = new TotCalculator();
        int actual = calc.completionByTag(this.user, "Day", this.tag);
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

}
