package screens.ScheduleEvent;

public class ScheduleEventResponseModel {
    public String getEventName() {
        return event_name;
    }

    public void setEventName(String event_name) {
        this.event_name = event_name;
    }

    String event_name;

    public ScheduleEventResponseModel(String event_name){
        this.event_name = event_name;
    }
}
