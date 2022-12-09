package entities;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.*;
import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
public class TimerTest {

//    @BeforeClass
//    public static void testSetup() {
//        Duration inputDuration = Duration.ofSeconds(50);
//        tester = new Timer(inputDuration);
//    }
    @Test
    public void testConstructor() {
        Duration inputDuration = Duration.ofSeconds(50);
        Timer tester = new Timer(inputDuration);
        assertEquals(inputDuration.getSeconds(), tester.startDuration.getSeconds(), tester.remainingDuration.getSeconds());
        assertEquals(tester.totalStudyTime.getSeconds(), 0);
    }
    @Test
    public void testSetRemainingDuration() {
        Duration inputDuration = Duration.ofSeconds(50);
        Timer tester = new Timer(inputDuration);
        tester.setRemainingDuration(LocalDateTime.now().plusMinutes(1));
        assertNotEquals(tester.startDuration.getSeconds(), tester.remainingDuration.getSeconds());
        assert(tester.remainingDuration.getSeconds() < inputDuration.getSeconds());
        assertNotEquals(tester.totalStudyTime.getSeconds(), 0);
    }

}
