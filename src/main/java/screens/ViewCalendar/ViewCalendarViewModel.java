package screens.ViewCalendar;

import useCases.ViewCalendar.ViewCalendarResponseModel;

import java.util.ArrayList;
import java.util.List;

public class ViewCalendarViewModel implements ViewModelSubjectInterface {

    /**
     * Observers of the view model.
     */
    List<ViewModelObserver> observers;

    /**
     * Events to show on the calendar.
     */
    List<EventPanel> eventPanelList;

    /**
     * A failure message.
     */
    String failure_message;


    /**
     * A constructor of the view model.
     */
    public ViewCalendarViewModel(){
        this.observers = new ArrayList<>();
        this.eventPanelList = new ArrayList<>();
    }

    /**
     * A method that causes the view model to update itself with a
     * list of new panels of events.
     */
    public void updateViewModel(List<EventPanel> eventPanelList){
        this.eventPanelList = eventPanelList;
        updateObservers();
    }

    /**
     * Add an observer.
     * @param observer a new observer of the view mdoel
     */
    @Override
    public void addObserver(ViewModelObserver observer) {
        observers.add(observer);

    }

    /**
     * Remove an observer.
     * @param observer an observer of the view mdoel
     */
    @Override
    public void removeObserver(ViewModelObserver observer){
        observers.remove(observer);
    }

    /**
     * Update all observers that observe this view model.
     */
    @Override
    public void updateObservers() {
        for(ViewModelObserver observer: observers){
            observer.update();
        }
    }

    /**
     * Get all event panels that are in the view model.
     * @return a list of event panels.
     */
    public List<EventPanel> getEventPanelList(){
        return this.eventPanelList;
    }

    /**
     * Register a failure with the given error message
     * @param errorMessage the error message
     */
    public void registerFailure(String errorMessage) {
        this.failure_message = errorMessage;
    }

    /**
     * Set the failure message to null.
     */
    public void clearFailureMessage(){
        this.failure_message = null;
    }
}
