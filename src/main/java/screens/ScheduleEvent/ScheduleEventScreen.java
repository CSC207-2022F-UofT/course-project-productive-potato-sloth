package screens.ScheduleEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import com.github.lgooddatepicker.components.DateTimePicker;
import screens.CheckboxListItem;
import screens.CheckboxListRenderer;
import screens.LabelTextPanel;


// From Paul's UserRegisterScreen

public class ScheduleEventScreen extends JPanel implements ActionListener {
    /**
     * The name of the event chosen by the user
     */
    JTextField eventName = new JTextField(15);

    DateTimePicker start_time = new DateTimePicker();

    DateTimePicker end_time = new DateTimePicker();

    JTextField collaborator_usernames = new JTextField(40);

    /**
     * The password
     */
    JPasswordField password = new JPasswordField(15);
    /**
     * The second password to make sure the user understands
     */
    JPasswordField repeatPassword = new JPasswordField(15);

    //    UserRegisterController userRegisterController;

    /**
     * A window with a title and a JButton.
     */
    public ScheduleEventScreen() {

//        this.userRegisterController = controller;

        JLabel title = new JLabel("Schedule a new event");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(title);

        LabelTextPanel eventNameInfo = new LabelTextPanel(
                new JLabel("Event name: "), eventName);
        this.add(eventNameInfo);

        JPanel start_time_panel = new JPanel();
        JLabel start_time_panel_text = new JLabel("Start time: ");
        start_time_panel.add(start_time_panel_text);
        start_time_panel.add(start_time);
        this.add(start_time_panel);

        JPanel end_time_panel = new JPanel();
        JLabel end_time_panel_text = new JLabel("End time: ");
        end_time_panel.add(end_time_panel_text);
        end_time_panel.add(end_time);
        this.add(end_time_panel);

        JLabel collaborator_usernames_info_label = new JLabel("Collaborator Usernames (comma separated): ");
        JPanel collaborator_usernames_info = new JPanel();
        collaborator_usernames_info.add(collaborator_usernames_info_label);
        collaborator_usernames_info.add(collaborator_usernames);
        this.add(collaborator_usernames_info);

        JLabel task_info_label = new JLabel("Select Task: ");
        JPanel task_info = new JPanel();
        task_info.add(task_info_label);
        String[] taskNames = {"India", "USA"};
        JComboBox<String> task_combo_box = new JComboBox<>(taskNames);
        task_info.add(task_combo_box);
        this.add(task_info);

        JLabel tag_info_label = new JLabel("Select Tags: ");
        JPanel tag_info = new JPanel();
        tag_info.add(tag_info_label);
        String[] tagNames = {"hehe", "hoohoo"};
        JComboBox<String> tag_combo_box = new JComboBox<>(tagNames);
        tag_info.add(tag_combo_box);
        this.add(tag_info);

        CheckboxListItem[] checkBoxes = new CheckboxListItem[]{};
        CheckboxListItem checkBox = new CheckboxListItem("Hello");
        JList<CheckboxListItem> list = new JList<>(new CheckboxListItem[]{});
        list.setCellRenderer(new CheckboxListRenderer());
        list.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent event) {
                JList<CheckboxListItem> list =
                        (JList<CheckboxListItem>) event.getSource();

                // Get index of item clicked

                int index = list.locationToIndex(event.getPoint());
                CheckboxListItem item = (CheckboxListItem) list.getModel()
                        .getElementAt(index);

                // Toggle selected state

                item.setSelected(!item.isSelected());

                // Repaint cell

                list.repaint(list.getCellBounds(index, index));
            }
        });
        this.add(list);


        JButton scheduleButton = new JButton("Schedule");
        JButton cancel = new JButton("Cancel");
        JPanel buttons = new JPanel();
        buttons.add(scheduleButton);
        buttons.add(cancel);
        this.add(buttons);

        scheduleButton.addActionListener(this);
        cancel.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
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
