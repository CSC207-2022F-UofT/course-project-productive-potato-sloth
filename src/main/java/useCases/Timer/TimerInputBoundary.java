package useCases.Timer;

// Use case layer

public interface TimerInputBoundary {

    TimerResponseModel create(TimerRequestModel requestModel);
}
