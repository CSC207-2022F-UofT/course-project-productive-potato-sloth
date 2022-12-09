package screens.ViewCalendar;

import controllers.Events.ViewCalendarController;
import screens.ScheduleEvent.UseCaseObserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A screen for viewing the calendar of the user.
 */
public class ViewCalendarScreen extends JPanel implements ActionListener, ViewModelObserver, UseCaseObserver {
    /**
     * The View Model.
     */
    ViewCalendarViewModel viewModel;
    /**
     * A controller for executing the use case.
     */
    ViewCalendarController controller;

    /**
     * A panel that contains all events.
     */
    JPanel calendarPanel;

    /**
     * Constraints for the calendarPanel view.
     */
    GridBagConstraints constraints;

    /**
     * A constructor for this screen.
     * @param controller the controller that executes the use case.
     * @param viewModel the model that stores all event panels.
     */
    public ViewCalendarScreen(ViewCalendarController controller, ViewCalendarViewModel viewModel){

        this.viewModel = viewModel;
        this.controller = controller;
        this.controller.loadEvents();

        calendarPanel = new JPanel();
        calendarPanel.setPreferredSize(new Dimension(1000, 2000));
        constraints = new GridBagConstraints();

        this.add(calendarPanel);
    }

    /**
     * Re-render all events in the event panel.
     */
    public void renderEvents(){
//        calendarPanel = new JPanel(new BoxLayout(calendarPanel, BoxLayout.X_AXIS));
        calendarPanel.removeAll();
        System.out.println("Rendering " + viewModel.getEventPanelList().size() + " events");
        for(EventPanel panel: viewModel.getEventPanelList()){
            calendarPanel.add(panel, constraints);
//            constraints.gridy += 1;
        }
        calendarPanel.revalidate();
        calendarPanel.repaint();
    }

    /**
     * When a button is clicked to load the screen.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.controller.loadEvents();
    }

    /**
     * Update method since the screen observes the view model.
     */
    @Override
    public void update() {
        renderEvents();
    }

    /**
     * Update method since the screen observes the ScheduleEvent use case,
     * after which it updates itself by calling the controller to fetch all
     * events.
     */
    @Override
    public void useCaseUpdate() {
        controller.loadEvents();
    }
}