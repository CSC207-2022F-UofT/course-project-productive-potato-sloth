package useCases.Timer;

// Use case layer

public interface TimerPresenter {
    TimerOutputData prepareSuccessView(TimerOutputData timerOutputData);
    TimerOutputData prepareFailView(String error);
}