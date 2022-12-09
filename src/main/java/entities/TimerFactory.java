package entities;
import java.time.Duration;

public class TimerFactory {

    public Timer create(Duration duration) {return new Timer(duration);}
}
