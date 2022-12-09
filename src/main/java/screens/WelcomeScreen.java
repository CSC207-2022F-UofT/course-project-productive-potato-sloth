package screens;

import screens.TaskList.TaskListScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import screens.Calculator.OutPutHistogram;
import screens.Timer.TimerMainGUI;

//UI layer

public class WelcomeScreen extends JFrame implements ActionListener {

    TaskListScreen taskListScreen;

    /**
     * The main welcome window of the application, acts like a home screen
     */
    public WelcomeScreen(
            TaskListScreen taskListScreen
    ) {
        this.taskListScreen = taskListScreen;

        JLabel title = new JLabel("Welcome Potato Sloths!");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton timer = new JButton("Start Timer");
        JButton viewSchedule = new JButton("View Schedule");
        JButton viewTasks = new JButton("View Tasks");
        JButton seePerformance = new JButton("See Performance");

        JPanel buttons = new JPanel();
        buttons.add(timer);
        buttons.add(viewSchedule);
        buttons.add(viewTasks);
        buttons.add(seePerformance);

        timer.addActionListener(this::actionPerformedTimer);
        seePerformance.addActionListener(this::actionPerformedCalculator);

        viewTasks.addActionListener(this::actionPerformedTaskList);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        main.add(title);
        main.add(buttons);
        this.setContentPane(main);
        this.pack();
    }

    private void actionPerformedCalculator(ActionEvent actionEvent) {
        OutPutHistogram histogram = new OutPutHistogram();
        histogram.produce_graph();
    }

    /**
     * Action Listener for the Timer Feature
     */
    public void actionPerformedTimer(ActionEvent evt) {

        TimerMainGUI.displayTimerScreen();
    }

    public void actionPerformedTaskList(ActionEvent evt) {
        taskListScreen.showScreen();
    }

    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }
}