package usecases.ViewCalendar;

import entities.dataObjects.EventDataResponseObject;
import screens.ViewCalendar.EventPanel;
import screens.ViewCalendar.ViewCalendarViewModel;

import java.util.ArrayList;
import java.util.List;

public class ViewCalendarResponseFormatter implements ViewCalendarPresenter {

    ViewCalendarViewModel viewModel;

    public ViewCalendarResponseFormatter(ViewCalendarViewModel viewModel){
        this.viewModel = viewModel;
    }

    @Override
    public void prepareSuccessView(ViewCalendarResponseModel response) {

        List<EventPanel> eventPanelList = new ArrayList<>();

        for(EventDataResponseObject eventDataResponseObject: response.getEventList()){
            EventPanel newEventPanel = new EventPanel(eventDataResponseObject);
            eventPanelList.add(newEventPanel);
        }

        viewModel.updateViewModel(eventPanelList);

    }

    @Override
    public void prepareFailView(String errorMessage) {

        viewModel.registerFailure(errorMessage);

    }
}
