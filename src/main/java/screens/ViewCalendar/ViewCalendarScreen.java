package screens.ViewCalendar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ViewCalendarScreen extends JPanel implements ActionListener, ViewModelObserver {
    ViewCalendarViewModel viewModel;
    ViewCalendarController controller;

    public ViewCalendarScreen(ViewCalendarController controller, ViewCalendarViewModel viewModel){

        this.viewModel = viewModel;
        this.controller = controller;
        this.controller.loadEvents();

    }

    public void renderEvents(){
        for(EventPanel panel: viewModel.getEventPanelList()){
            this.add(panel);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void update() {
        renderEvents();
    }
}