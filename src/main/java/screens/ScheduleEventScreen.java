package screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.github.lgooddatepicker.components.DateTimePicker;


// From Paul's UserRegisterScreen

public class ScheduleEventScreen extends JPanel implements ActionListener {
    /**
     * The name of the event chosen by the user
     */
    JTextField eventName = new JTextField(15);

    DateTimePicker dateTimePicker1 = new DateTimePicker();

    /**
     * The password
     */
    JPasswordField password = new JPasswordField(15);
    /**
     * The second password to make sure the user understands
     */
    JPasswordField repeatPassword = new JPasswordField(15);

    /**
     * The controller
     */
//    UserRegisterController userRegisterController;

    /**
     * A window with a title and a JButton.
     */
    public ScheduleEventScreen() {

//        this.userRegisterController = controller;

        JLabel title = new JLabel("Schedule a new event");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel eventNameInfo = new LabelTextPanel(
                new JLabel("Event Name"), eventName);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("Choose password"), password);
        LabelTextPanel repeatPasswordInfo = new LabelTextPanel(
                new JLabel("Enter password again"), repeatPassword);

        JButton signUp = new JButton("Sign up");
        JButton cancel = new JButton("Cancel");

        JPanel buttons = new JPanel();
        buttons.add(signUp);
        buttons.add(cancel);

        signUp.addActionListener(this);
        cancel.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(eventNameInfo);
        this.add(passwordInfo);
        this.add(repeatPasswordInfo);
        this.add(buttons);
        this.add(dateTimePicker1);
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    public static void main(String[] args) {
        JFrame application = new JFrame("Schedule Event");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);
        ScheduleEventScreen scheduleEventScreen = new ScheduleEventScreen();
        screens.add(scheduleEventScreen, "welcome");
        cardLayout.show(screens, "register");
        application.pack();
        application.setVisible(true);
    }
}
