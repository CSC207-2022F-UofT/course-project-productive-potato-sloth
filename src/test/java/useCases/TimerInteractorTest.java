package useCases;

import entities.TimerFactory;
import useCases.Timer.*;
import org.junit.jupiter.api.Test;
import useCases.Timer.TimerInputData;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class TimerInteractorTest {

    @Test
    void create() {

        TimerPresenter presenter = new TimerPresenter() {
            @Override
            public TimerOutputData prepareSuccessView(TimerOutputData outputData) {
                // Check that the Output Data and associated changes
                // are correct

                Duration inputDuration = Duration.ofSeconds(60);
                assertEquals(inputDuration, outputData.getDurationOfTimer());

                Duration wrongInputDuration = Duration.ofSeconds(50);
                // just some random duration which will not be equal
                assertNotEquals(wrongInputDuration, outputData.getDurationOfTimer());

                return null;
            }

            @Override
            public TimerOutputData prepareFailView(String error) {
                fail("Use case failure is unexpected.");
                return null;
            }
        };

        TimerFactory timerFactory = new TimerFactory();
        Duration inputDuration = Duration.ofSeconds(60);
        TimerInputData inputData = new TimerInputData(inputDuration);
        TimerInputBoundary interactor = new TimerInteractor(presenter, timerFactory);
        interactor.create(inputData);

    }
}
