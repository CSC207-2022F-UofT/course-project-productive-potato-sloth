package screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import screens.MainInvitationScreen.MainInvitationMethod;
import screens.TaskList.TaskListScreen;
import screens.Timer.TimerMainGUI;
//import screens.Timer.TimerMainGUI;

//UI layer

public class WelcomeScreen extends JFrame implements ActionListener {

    JButton invitation; // the button that calls the main invitation screen
    MainInvitationMethod invitation_main;
    TaskListScreen taskListScreen;

    /**
     * The main welcome window of the application, acts like a home screen
     */
    public WelcomeScreen(MainInvitationMethod invitation_main, TaskListScreen taskListScreen) {

        JLabel title = new JLabel("Welcome Potato Sloths!");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton timer = new JButton("Start Timer");
        JButton viewSchedule = new JButton("View Schedule");
        JButton createTask = new JButton("View Schedule");
        invitation = new JButton("Manage invitations");
        JButton viewTasks = new JButton("View Tasks");

        JPanel buttons = new JPanel();
        buttons.add(timer);
        buttons.add(viewSchedule);
        buttons.add(createTask);
        buttons.add(invitation);


        timer.addActionListener(this::actionPerformedTimer);
        viewTasks.addActionListener(this::actionPerformedTaskList);
        invitation.addActionListener(this);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        main.add(title);
        main.add(buttons);
        this.setContentPane(main);
        this.pack();
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
}