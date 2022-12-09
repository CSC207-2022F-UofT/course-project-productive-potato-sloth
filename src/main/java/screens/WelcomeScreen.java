package screens;

import screens.CreateAccount.CreateAccountMain;
import screens.Login.LoginMain;
import screens.TaskList.TaskListScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import screens.Timer.TimerMainGUI;

// GUI layer

public class WelcomeScreen extends JFrame implements ActionListener {

    TaskListScreen taskListScreen;
    ViewCalendarMainFrame viewCalendarMainFrame;

    /**
     * The main welcome window of the application, acts like a home screen
     */
    public WelcomeScreen(
            TaskListScreen taskListScreen,
            ViewCalendarMainFrame viewCalendarMainFrame
    ) {
        this.taskListScreen = taskListScreen;
        this.viewCalendarMainFrame = viewCalendarMainFrame;

        JLabel title = new JLabel("Welcome Potato Sloths!");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton timer = new JButton("Start Timer");
        JButton viewSchedule = new JButton("View Schedule");
        JButton viewTasks = new JButton("View Tasks");
        JButton login = new JButton("Login");
        JButton createAccount = new JButton("Create Account");

        JPanel buttons = new JPanel();
        buttons.add(timer);
        buttons.add(viewSchedule);
        buttons.add(viewTasks);
        buttons.add(login);
        buttons.add(createAccount);

        timer.addActionListener(this::actionPerformedTimer);

        viewSchedule.addActionListener(this::actionPerformedViewCalendar);

        viewTasks.addActionListener(this::actionPerformedTaskList);

        login.addActionListener(this::actionPerfectLogin);
        createAccount.addActionListener(this::actionPerformedCreateAccount);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        main.add(title);
        main.add(buttons);
        this.setContentPane(main);
        this.pack();
    }

    private void actionPerformedCreateAccount(ActionEvent actionEvent) {
        try {
            CreateAccountMain.main(null);
        } catch (IOException ignored) {}
    }

    private void actionPerfectLogin(ActionEvent actionEvent) {
        try {
            LoginMain.main(null);
        } catch (IOException e) {
        }

    }

    public void actionPerformedViewCalendar(ActionEvent evt){
        viewCalendarMainFrame.runViewCalendarUseCase();
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