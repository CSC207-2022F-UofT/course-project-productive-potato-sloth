package screens;

import main.ChatRoomDemo;
import screens.TaskList.TaskListScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import screens.Timer.TimerMainGUI;
import services.CurrentUserService;

// GUI layer

public class WelcomeScreen extends JFrame implements ActionListener {

    TaskListScreen taskListScreen;
    CurrentUserService service;
    ChatRoomDemo demo;

    /**
     * The main welcome window of the application, acts like a home screen
     */
    public WelcomeScreen(
            TaskListScreen taskListScreen, CurrentUserService service
    ) {
        this.taskListScreen = taskListScreen;
        this.service = service;
        this.demo = new ChatRoomDemo(service);

        JLabel title = new JLabel("Welcome Potato Sloths!");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton timer = new JButton("Start Timer");
        JButton viewSchedule = new JButton("View Schedule");
        JButton viewTasks = new JButton("View Tasks");
        JButton viewChatRoom = new JButton("view ChatRoom");

        JPanel buttons = new JPanel();
        buttons.add(timer);
        buttons.add(viewSchedule);
        buttons.add(viewTasks);
        buttons.add(viewChatRoom);

        timer.addActionListener(this::actionPerformedTimer);

        viewTasks.addActionListener(this::actionPerformedTaskList);

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
    }
    public void actionPerformedViewChatRoom(ActionEvent evt){
        demo.initialize();
    }
}