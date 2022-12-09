package screens;



import main.ChatRoomDemo;
import screens.CreateAccount.CreateAccountMain;
import screens.Login.LoginMain;
import screens.TaskList.TaskListScreen;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


import screens.MainInvitationScreen.MainInvitationMethod;
import screens.TaskList.TaskListScreen;
import screens.Timer.TimerMainGUI;
//import screens.Timer.TimerMainGUI;

import screens.Calculator.OutPutHistogram;
import screens.Timer.TimerMainGUI;
import services.CurrentUserService;


//UI layer

public class WelcomeScreen extends JFrame implements ActionListener {

    JButton invitation; // the button that calls the main invitation screen
    MainInvitationMethod invitation_main;
    TaskListScreen taskListScreen;
    CurrentUserService service;
    ChatRoomDemo demo;

    /**
     * The main welcome window of the application, acts like a home screen
     */

    public WelcomeScreen(
            TaskListScreen taskListScreen, CurrentUserService service, MainInvitationMethod invitation_main
    ) {
        this.taskListScreen = taskListScreen;
        this.service = service;
        this.demo = new ChatRoomDemo(service);


        JLabel title = new JLabel("Welcome Potato Sloths!");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton timer = new JButton("Start Timer");
        JButton viewSchedule = new JButton("View Schedule");
        JButton createTask = new JButton("View Schedule");
        invitation = new JButton("Manage invitations");
        JButton viewTasks = new JButton("View Tasks");
        JButton viewChatRoom = new JButton("view ChatRoom");
        JButton login = new JButton("Login");
        JButton createAccount = new JButton("Create Account");
        JButton seePerformance = new JButton("See Performance");

        JPanel buttons = new JPanel();
        buttons.add(timer);
        buttons.add(viewSchedule);

        buttons.add(createTask);
        buttons.add(invitation);


        buttons.add(viewTasks);
        buttons.add(viewChatRoom);
        buttons.add(login);
        buttons.add(createAccount);
        buttons.add(seePerformance);

        timer.addActionListener(this::actionPerformedTimer);
        seePerformance.addActionListener(this::actionPerformedCalculator);


        timer.addActionListener(this::actionPerformedTimer);
        viewTasks.addActionListener(this::actionPerformedTaskList);
        invitation.addActionListener(this);

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

        if (evt.getSource() == invitation){
            invitation_main.setVisible(true);
        }
    }
    public void actionPerformedViewChatRoom(ActionEvent evt){
        demo.initialize();
    }
}