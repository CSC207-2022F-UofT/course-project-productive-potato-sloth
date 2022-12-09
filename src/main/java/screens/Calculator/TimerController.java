//package screens.Calculator;
//
//import useCases.Calculator.CalculatorInterface;
//import useCases.Timer.TimerInputBoundary;
//import useCases.Timer.TimerInputData;
//import useCases.Timer.TimerOutputData;
//
//import java.time.Duration;
//
//// Interface adapters layer
//
//public class CalculatorController {
//
//    final CalculatorInterface Input;
//
//    public TimerController(TimerInputBoundary timerInput) {
//
//        this.timerInput = timerInput;
//    }
//
//    TimerOutputData create(Duration timerDuration) {
//        TimerInputData inputData = new TimerInputData(timerDuration);
//
//        return timerInput.create(inputData);
//    }
//}
