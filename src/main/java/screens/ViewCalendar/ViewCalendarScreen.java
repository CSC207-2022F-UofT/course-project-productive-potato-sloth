package screens.ViewCalendar;

import screens.ScheduleEvent.UseCaseObserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ViewCalendarScreen extends JPanel implements ActionListener, ViewModelObserver, UseCaseObserver {
    ViewCalendarViewModel viewModel;
    ViewCalendarController controller;

    JPanel calendarPanel;
    GridBagConstraints constraints;

    public ViewCalendarScreen(ViewCalendarController controller, ViewCalendarViewModel viewModel){

        this.viewModel = viewModel;
        this.controller = controller;
        this.controller.loadEvents();

        calendarPanel = new JPanel(new GridBagLayout());
        constraints = new GridBagConstraints();

        this.add(calendarPanel);
    }

    public void renderEvents(){
//        calendarPanel.setLayout(new GridBagLayout());
        for(EventPanel panel: viewModel.getEventPanelList()){
            calendarPanel.add(panel, constraints);
            constraints.gridy += 1;
        }
        calendarPanel.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.controller.loadEvents();
    }

    @Override
    public void update() {
        renderEvents();
    }

    @Override
    public void useCaseUpdate() {
        controller.loadEvents();
    }
}