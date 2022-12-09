package screens.Calculator;

import screens.Timer.TimerCreationFailed;
import useCases.Timer.TimerOutputData;
import useCases.Timer.TimerPresenter;

import java.time.Duration;

// Interface layer

public class TimerResponseFormatter implements TimerPresenter {

    @Override
    public TimerOutputData prepareSuccessView(TimerOutputData timerOutput) {
        Duration durationOfTimer = timerOutput.getDurationOfTimer();
        return timerOutput;
    }

    @Override
    public TimerOutputData prepareFailView(String error) {
        throw new TimerCreationFailed(error);
    }
}
