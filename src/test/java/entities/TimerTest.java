package entities;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
public class TimerTest {
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
        tester.setRemainingDuration(LocalDateTime.now().plusSeconds(15));
        assertNotEquals(tester.startDuration.getSeconds(), tester.remainingDuration.getSeconds());
        assert(tester.startDuration.getSeconds() > tester.remainingDuration.getSeconds());
        assertNotEquals(tester.totalStudyTime.getSeconds(), 0);
    }

}
