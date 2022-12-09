package useCases.ViewCalendar;

import entities.Event;
import entities.dataObjects.EventDataResponseObject;
import screens.ViewCalendar.EventPanel;
import screens.ViewCalendar.ViewCalendarViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A response formatter that implements the presenter.
 */
public class ViewCalendarResponseFormatter implements ViewCalendarPresenter {

    /**
     * The view model that this response formatter
     * updates.
     */
    ViewCalendarViewModel viewModel;

    /**
     * A constructor for the response formatter.
     * @param viewModel the view model needed to be updated when methods of the presenter are called.
     */
    public ViewCalendarResponseFormatter(ViewCalendarViewModel viewModel){
        this.viewModel = viewModel;
    }

    /**
     * Prepare a success view.
     * @param response a response model for updating the view model
     */
    @Override
    public void prepareSuccessView(ViewCalendarResponseModel response) {

        List<EventPanel> eventPanelList = new ArrayList<>();

        for(EventDataResponseObject eventDataResponseObject: response.getEventList()){
            EventPanel newEventPanel = new EventPanel(eventDataResponseObject);
            eventPanelList.add(newEventPanel);
        }

        viewModel.updateViewModel(eventPanelList);

    }

    /**
     * Prepare a failure view.
     * @param errorMessage an error to add into the view model
     */
    @Override
    public void prepareFailView(String errorMessage) {

        viewModel.registerFailure(errorMessage);

    }
}