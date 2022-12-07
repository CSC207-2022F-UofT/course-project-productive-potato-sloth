package screens.ScheduleEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import com.github.lgooddatepicker.components.DateTimePicker;
import screens.*;
import screens.ViewCalendar.ViewModelObserver;
import screens.ViewCalendar.ViewModelSubjectInterface;


// From Paul's UserRegisterScreen

public class ScheduleEventScreen extends JPanel implements ActionListener, UseCaseSubjectInterface {
    /**
     * The name of the event chosen by the user
     */
    JTextField eventName = new JTextField(15);

    DateTimePicker start_time = new DateTimePicker();

    DateTimePicker end_time = new DateTimePicker();

    JList<String> tagSelectionList = new JList<>();

    JComboBox<String> task_combo_box;

    ScheduleEventController scheduleEventController;

    ScheduleEventViewModel view_model;

    List<UseCaseObserver> observerList;

    /**
     * A window with a title and a JButton.
     */
    public ScheduleEventScreen(ScheduleEventController controller, ScheduleEventViewModel view_model) {

        this.view_model = view_model;
        this.scheduleEventController = controller;
        this.observerList = new ArrayList<>();

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

        JPanel tag_panel = new JPanel();
        JLabel tag_info_label = new JLabel("Select Tags: ");
        tag_panel.add(tag_info_label);

        DefaultListModel<String> tagSelectionListModel = new DefaultListModel<>();
        for(String tagName: view_model.getTagNamesArray()){
            tagSelectionListModel.addElement(tagName);
        }
        ListSelectionDocument listSelectionDocument = new ListSelectionDocument();
        tagSelectionList.setCellRenderer(new CheckboxListCellRenderer<>());
        tagSelectionList.setModel(tagSelectionListModel);
        tagSelectionList.addListSelectionListener(listSelectionDocument);
        tag_panel.add(tagSelectionList);

        this.add(tag_panel);

        JButton scheduleButton = new JButton("Schedule");
        JPanel buttons = new JPanel();
        buttons.add(scheduleButton);
        this.add(buttons);

        scheduleButton.addActionListener(this);

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
                            tagSelectionList.getSelectedValuesList()
                    );
                    JOptionPane.showMessageDialog(this, "Event with name "
                            + "\"" + responseModel.getEventName() + "\""
                            + " created with start time " + start_time.getDateTimePermissive()
                            + " end time " + end_time.getDateTimePermissive()
                            + ", tagged with " + String.join(", ", tagSelectionList.getSelectedValuesList())
                            + " and linked to " + task_combo_box.getItemAt(task_combo_box.getSelectedIndex())
                            + ".");
                    this.updateUseCaseObservers();
                } catch (Exception e){
                    JOptionPane.showMessageDialog(this, e.getMessage());
                }
            }
            case "Cancel": {

            }
        }
    }

    @Override
    public void addUseCaseObserver(UseCaseObserver observer) {
        this.observerList.add(observer);
    }

    @Override
    public void removeUseCaseObserver(UseCaseObserver observer) {
        this.observerList.remove(observer);
    }

    @Override
    public void updateUseCaseObservers() {
        for(UseCaseObserver observer: this.observerList){
            observer.useCaseUpdate();
        }
    }
}
