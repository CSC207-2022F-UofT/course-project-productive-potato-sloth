package useCases.ScheduleEvent;

import entities.Event;
import entities.Tag;
import entities.Task;
import entities.User;
import gateways.DataAccessInterface;
import services.CurrentUserService;

import java.util.ArrayList;
import java.util.List;

// TODO: document this class
public class ScheduleEventInteractor {

    CurrentUserService currentUserService;
    DataAccessInterface<User> database;

    ScheduleEventInteractor(CurrentUserService currentUserService, DataAccessInterface<User> database){
        this.currentUserService = currentUserService;
        this.database = database;
    }

    public void scheduleEvent(ScheduleEventInputData inputData){

        User currentUser = currentUserService.getCurrentUser();

        /*
        Check that the task exists, if given. Select it.
        Once the User.getTask(taskName) method is implemented, this code will be
        significantly simplified.
         */

        Task selectedTask = null;

        if(inputData.taskName != null){
            for(Task task: currentUser.getTasks()){
                if(task.getName().equals(inputData.taskName)){
                    selectedTask = task;
                    break;
                }
            }
            if(selectedTask == null){
                throw new RuntimeException("Task with name " + inputData.taskName + " does not exist.");
            }
        }

        /*
        Check that the tags exist. Select them into an array.
        Once the User.getTag(tagName) method is implemented, this code will be
        significantly simplified.
         */

        List<Tag> eventTags = new ArrayList<>();
        for(String tagName: inputData.tagNames){
            for(Tag tag: currentUser.getTags()){
                if(tag.getName().equals(tagName)){
                    eventTags.add(tag);
                }
            }
        }

        /*
        Check that frequency is null if and only if repeats is null.
         */

        if(inputData.frequency == null && inputData.repeats){
            throw new RuntimeException("Repeat frequency not specified!");
        } else if (inputData.frequency != null && !inputData.repeats) {
            inputData.frequency = null;
        }

        /*
        Add the event.
         */

        Event newEvent = new Event(
                inputData.start_time,
                inputData.end_time,
                selectedTask,
                inputData.name,
                inputData.repeats,
                inputData.frequency,
                eventTags
        );

        currentUser.addEvent(newEvent);
    }
}
