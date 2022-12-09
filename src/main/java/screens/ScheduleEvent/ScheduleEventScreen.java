package screens.ScheduleEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import com.github.lgooddatepicker.components.DateTimePicker;
import controllers.Events.ScheduleEventController;
import screens.*;

/**
 * A screen for the ScheduleEvent use case containing a form
 * and a submit button.
 */
public class ScheduleEventScreen extends JPanel implements ActionListener, UseCaseSubjectInterface {
    /**
     * The name of the event chosen by the user
     */
    JTextField eventName = new JTextField(15);

    /**
     * the start time field chosen by the user.
     */
    DateTimePicker start_time = new DateTimePicker();

    /**
     * the end time field chosen by the user.
     */
    DateTimePicker end_time = new DateTimePicker();

    /**
     * A JList that contains the tags that the user
     * may select.
     */
    JList<String> tagSelectionList = new JList<>();

    /**
     * A Combo box that contains the task that the user
     * may select.
     */
    JComboBox<String> task_combo_box;

    /**
     * The ScheduleEventController.
     */
    ScheduleEventController scheduleEventController;

    /**
     * The ScheduleEventViewModel containing the tasks and tags
     * of the user for them to choose from.
     */
    ScheduleEventViewModel view_model;

    /**
     * The list of observers which are use cases that are observing
     * this use case.
     */
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

    /**
     * Add an observer that listens to when this use case succeeds
     * @param observer a use case which will now observe this one.
     */
    @Override
    public void addUseCaseObserver(UseCaseObserver observer) {
        this.observerList.add(observer);
    }

    /**
     * Remove an observer that listened to when this use case succeeds.
     * @param observer a use case which observes this one.
     */
    @Override
    public void removeUseCaseObserver(UseCaseObserver observer) {
        this.observerList.remove(observer);
    }

    /**
     * Update all observers which are use cases that observe this one.
     */
    @Override
    public void updateUseCaseObservers() {
        for(UseCaseObserver observer: this.observerList){
            observer.useCaseUpdate();
        }
    }
}
