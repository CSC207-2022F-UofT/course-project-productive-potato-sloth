package screens.ViewCalendar;

import entities.dataObjects.EventDataResponseObject;
import entities.dataObjects.TagDataObject;

import javax.swing.*;
import java.awt.*;
import java.time.format.DateTimeFormatter;

public class EventPanel extends JPanel {

    public EventPanel(EventDataResponseObject eventDataResponseObject) {

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.weightx = 0.5;

        JLabel nameField = new JLabel(eventDataResponseObject.getEventName());
        this.add(nameField, c);

        c.anchor = GridBagConstraints.LINE_START;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("KK:mm a, d MMM uuuu");

        JPanel startTimeField = new JPanel();
        JLabel startTimeFieldLabel = new JLabel("Start Time: ");
        JLabel startTime = new JLabel(eventDataResponseObject.getStartTime().format(formatter));
        startTimeField.add(startTimeFieldLabel);
        startTimeField.add(startTime);
        c.gridy = 1;
        this.add(startTimeField, c);

        JPanel endTimeField = new JPanel();
        JLabel endTimeFieldLabel = new JLabel("End Time: ");
        JLabel endTime = new JLabel(eventDataResponseObject.getEndTime().format(formatter));
        endTimeField.add(endTimeFieldLabel);
        endTimeField.add(endTime);
        c.gridy = 2;
        this.add(endTimeField, c);

        JPanel taskNameField = new JPanel();
        JLabel taskNameFieldLabel = new JLabel("Task: ");
        JLabel taskName = new JLabel(eventDataResponseObject.getSelectedTaskName());
        taskNameField.add(taskNameFieldLabel);
        taskNameField.add(taskName);
        c.gridy = 3;
        this.add(taskNameField, c);

        JPanel tagNameField = new JPanel();
        JLabel tagNamesFieldLabel = new JLabel("Tags: ");
        JList<String> tagNames = new JList<>();
        DefaultListModel<String> model = new DefaultListModel<>();
        for(TagDataObject tag: eventDataResponseObject.getTagDataObjects()){
            model.addElement(tag.getName());
        }
        tagNames.setModel(model);
        tagNameField.add(tagNamesFieldLabel);
        tagNameField.add(tagNames);
        c.gridy = 4;
        this.add(tagNameField, c);
    }
}
