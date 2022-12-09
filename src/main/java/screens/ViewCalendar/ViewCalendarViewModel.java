package screens.ViewCalendar;

import useCases.ViewCalendar.ViewCalendarResponseModel;

import java.util.ArrayList;
import java.util.List;

public class ViewCalendarViewModel implements ViewModelSubjectInterface {

    List<ViewModelObserver> observers;
    List<EventPanel> eventPanelList;
    String successStatus;
    String errorMessage;

    public ViewCalendarViewModel(){
        this.observers = new ArrayList<>();
        this.eventPanelList = new ArrayList<>();
        successStatus = "loading";
    }

    public void updateViewModel(List<EventPanel> eventPanelList){
        this.eventPanelList = eventPanelList;
        updateObservers();
        successStatus = "success";
        this.errorMessage = null;
    }

    public void registerFailure(String errorMessage){
        this.eventPanelList = new ArrayList<>();
        this.errorMessage = errorMessage;
        successStatus = "failure";
    }

    public String getSuccessStatus(){
        return successStatus;
    }

    public String getErrorMessage(){
        return errorMessage;
    }

    @Override
    public void addObserver(ViewModelObserver observer) {
        observers.add(observer);

    }

    @Override
    public void removeObserver(ViewModelObserver observer){
        observers.remove(observer);
    }

    @Override
    public void updateObservers() {
        for(ViewModelObserver observer: observers){
            observer.update();
        }
    }

    public List<EventPanel> getEventPanelList(){
        return this.eventPanelList;
    }
}
