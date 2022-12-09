package screens.Calculator;

import entities.TimerFactory;
import screens.Timer.TimerController;
import screens.Timer.TimerResponseFormatter;
import screens.Timer.TimerScreen;
import useCases.Timer.TimerInputBoundary;
import useCases.Timer.TimerInteractor;
import useCases.Timer.TimerPresenter;

import javax.swing.*;
import java.awt.*;

public class TimerMainGUI {
    public static void displayTimerScreen() {

        JFrame timerFrame = new JFrame("Timer");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        timerFrame.add(screens);


        TimerPresenter timerPresenter = new TimerResponseFormatter();
        TimerFactory timerFactory = new TimerFactory();
        TimerInputBoundary timerInteractor = new TimerInteractor(timerPresenter, timerFactory);
        screens.Timer.TimerController timerController = new TimerController(timerInteractor);


        TimerScreen timerScreen = new TimerScreen(timerController);
        screens.add(timerScreen, "welcome");
        cardLayout.show(screens, "timer");
        timerFrame.pack();
        timerFrame.setVisible(true);

    }

}