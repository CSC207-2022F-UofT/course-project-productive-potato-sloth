package screens.ScheduleEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.github.lgooddatepicker.components.DateTimePicker;
import screens.CheckboxListItem;
import screens.CheckboxListRenderer;
import screens.LabelTextPanel;
import services.CurrentUserService;
import useCases.ScheduleEvent.ScheduleEventInputBoundary;


// From Paul's UserRegisterScreen

public class ScheduleEventScreen extends JPanel implements ActionListener {
    /**
     * The name of the event chosen by the user
     */
    JTextField eventName = new JTextField(15);

    DateTimePicker start_time = new DateTimePicker();

    DateTimePicker end_time = new DateTimePicker();

    /**
     * The password
     */
    JPasswordField password = new JPasswordField(15);
    /**
     * The second password to make sure the user understands
     */
    JPasswordField repeatPassword = new JPasswordField(15);

    JComboBox<String> tag_combo_box = new JComboBox<String>();

    JComboBox<String> task_combo_box;

    ScheduleEventController scheduleEventController;

    ScheduleEventViewModel view_model;

    /**
     * A window with a title and a JButton.
     */
    public ScheduleEventScreen(ScheduleEventController controller, ScheduleEventViewModel view_model) {

        this.view_model = view_model;
        this.scheduleEventController = controller;

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

        JLabel task_info_label = new JLabel("Select Task: ");
        JPanel task_info = new JPanel();
        task_info.add(task_info_label);
        task_combo_box = new JComboBox<>(view_model.getTaskNamesArray());
        task_info.add(task_combo_box);
        this.add(task_info);

        JLabel tag_info_label = new JLabel("Select Tags: ");
        JPanel tag_info = new JPanel();
        tag_info.add(tag_info_label);
        String[] tagNames = view_model.getTagNamesArray();
        for(String tagName: tagNames){
            tag_combo_box.addItem(tagName);
        }
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

        switch(evt.getActionCommand()){
            case "Schedule": {
                try {
                    ScheduleEventResponseModel responseModel = scheduleEventController.scheduleEvent(
                            start_time.getDateTimePermissive(),
                            end_time.getDateTimePermissive(),
                            task_combo_box.getItemAt(task_combo_box.getSelectedIndex()),
                            eventName.getText(),
                            List.of(new String[]{"placeholder",})
                    );
                    JOptionPane.showMessageDialog(this, responseModel.getEventName() + " created.");
                } catch (Exception e){
                    JOptionPane.showMessageDialog(this, e.getMessage());
                }
            }
            case "Cancel": {

            }
        };
    }
}
