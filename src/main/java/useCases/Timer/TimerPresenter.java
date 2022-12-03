package useCases.Timer;

// Use case layer

public interface TimerPresenter {
    TimerResponseModel prepareSuccessView(TimerResponseModel timerOutputData);

    TimerResponseModel prepareFailView(String error);
}