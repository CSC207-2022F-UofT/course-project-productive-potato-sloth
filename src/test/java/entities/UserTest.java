package entities;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.time.Duration;

/**
 * A class which tests the User entity
 */
public class UserTest {
    User user = new User("group91", "softwaredesign");
    User user2 = new User();
    List<Tag> user_tags = new ArrayList<Tag>();
    List<Event> user_events = new ArrayList<Event>();
    List<Timer> user_timers = new ArrayList<Timer>();
    List<Task> user_tasks = new ArrayList<Task>();
    List<Invitation> user_incomingInvitations = new ArrayList<Invitation>();
    List<Invitation> user_outgoingInvitations = new ArrayList<Invitation>();

    /**
     * Tests to test the User constructor (given a username and password)
     */
    @Test
    public void testUserConstructorWithParameters(){
        assertEquals("group91", user.getUsername());
        assertEquals("softwaredesign", user.getPassword());
        assertTrue(user.getTags().isEmpty());
        assertTrue(user.getEvents().isEmpty());
        assertTrue(user.getTasks().isEmpty());
        assertTrue(user.getTimers().isEmpty());
        assertTrue(user.getIncomingInvitations().isEmpty());
        assertTrue(user.getOutgoingInvitations().isEmpty());
    }

    /**
     * Tests to test the User constructor (without username and password)
     */
    @Test
    public void testUserConstructorWithoutParameters(){
        assertEquals("", user2.getUsername());
        assertEquals("", user2.getPassword());
        assertTrue(user2.getTags().isEmpty());
        assertTrue(user2.getEvents().isEmpty());
        assertTrue(user2.getTasks().isEmpty());
        assertTrue(user2.getTimers().isEmpty());
        assertTrue(user2.getIncomingInvitations().isEmpty());
        assertTrue(user2.getOutgoingInvitations().isEmpty());
    }

    /**
     * Tests to test the User setters
     */
    @Test
    public void testUserSetters() {
        user.setUsername("Productive Potato Sloth");
        user.setPassword("csc207");
        assertEquals("Productive Potato Sloth", user.getUsername());
        assertEquals("csc207", user.getPassword());

    }

    /**
     * Tests to test the User add-methods, remove-methods, and getters
     */
    @Test
    public void testUserAddersAndRemoversAndGetters() {
        Tag tag = new Tag("csc207", Color.BLACK);
        user_tags.add(tag);
        List<Tag> tags = new ArrayList<>();
        tags.add(tag);
        Task task = new Task("Finish csc207 project", user2);
        user_tasks.add(task);
        Task task2 = new Task("Submit csc207 project", user);
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = LocalDateTime.of(2022, Month.JANUARY, 1, 10, 10, 30);
        Event event = new Event(start, end, task, "CSC207 Project", tags);
        user_events.add(event);
        Duration dur = Duration.between(LocalTime.NOON,LocalTime.MAX);
        Timer timer = new Timer(dur);
        user_timers.add(timer);
        Invitation outgoingInvitation = new Invitation(user, user2, task);
        user_outgoingInvitations.add(outgoingInvitation);
        Invitation incomingInvitation = new Invitation(user2, user, task2);
        user_incomingInvitations.add(incomingInvitation);

        user.addTag(tag);
        user.addEvent(event);
        user.addTask(task);
        user.addTimer(timer);
        user.addIncomingInvitation(incomingInvitation);
        user.addOutgoingInvitation(outgoingInvitation);

        assertEquals(user_tags, user.getTags());
        assertEquals(user_tasks, user.getTasks());
        assertEquals(user_timers, user.getTimers());
        assertEquals(user_events, user.getEvents());
        assertEquals(user_incomingInvitations, user.getIncomingInvitations());
        assertEquals(user_outgoingInvitations, user.getOutgoingInvitations());

        assertEquals(task, user.getTaskByName("Finish csc207 project"));
        assertEquals(tag, user.getTagByName("csc207"));

        user.removeTag(tag);
        user.removeEvent(event);
        user.removeTask(task);
        user.removeTimer(timer);
        user.removeIncomingInvitation(incomingInvitation);
        user.removeOutgoingInvitation(outgoingInvitation);

        assertTrue(user.getTags().isEmpty());
        assertTrue(user.getEvents().isEmpty());
        assertTrue(user.getTasks().isEmpty());
        assertTrue(user.getTimers().isEmpty());
        assertTrue(user.getIncomingInvitations().isEmpty());
        assertTrue(user.getOutgoingInvitations().isEmpty());

    }
}
