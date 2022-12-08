package useCases.Tasks;

import entities.Event;
import entities.Tag;
import entities.Task;
import entities.User;
import gateways.Tasks.TaskDataAccessInterface;
import gateways.Tasks.TaskInfoRequestModel;
import gateways.Tasks.TaskInfoResponseModel;
import presenters.TagPresenter;
import presenters.TaskInfoPresenter;
import presenters.TaskPresenter;
import services.CurrentUserService;

import java.util.ArrayList;

/**
 * A use case which retrieves all the fields of a Task
 */
public class GetTaskInfo implements GetTaskInfoInputBoundary {

    /**
     * The interface which allows access to the TaskDatabase
     */
    TaskDataAccessInterface taskDatabaseGateway;

    /**
     * The presenter for Task info
     */
    TaskInfoPresenter taskInfoPresenter;

    /**
     * The service allowing access to the current user
     */
    CurrentUserService currentUserService;

    /**
     * Creates an instance of GetTaskInfo with the required fields
     *
     * @param taskDatabaseGateway Interface for accessing Tasks
     * @param taskInfoPresenter   Presenter for Task info
     * @param currentUserService  Service for accessing the logged-in user
     */
    public GetTaskInfo(TaskDataAccessInterface taskDatabaseGateway, TaskInfoPresenter taskInfoPresenter, CurrentUserService currentUserService) {
        this.taskDatabaseGateway = taskDatabaseGateway;
        this.taskInfoPresenter = taskInfoPresenter;
        this.currentUserService = currentUserService;
    }

    /**
     * Gets all the info about a certain task specified in the Request
     *
     * @param taskInfoRequestModel Contains the name of the Task for which to return information
     * @return A Response Model containing the information about the Task
     */
    @Override
    public TaskInfoResponseModel getInfo(TaskInfoRequestModel taskInfoRequestModel) {
        Task task = taskDatabaseGateway.get(taskInfoRequestModel.getName());

        ArrayList<String> tagList = new ArrayList<>();
        ArrayList<String> eventList = new ArrayList<>();
        ArrayList<String> collaboratorList = new ArrayList<>();

        // Querying all Tags, Events, Collaborators into the response
        if (task.getTags() != null) {
            for (Tag tag : task.getTags()) {
                tagList.add(tag.getName());
            }
        }

        if (task.getEvents() != null) {
            for (Event event : task.getEvents()) {
                eventList.add(event.getName());
            }
        }

        if (task.getCollaborator() != null) {
            for (User collaborator : task.getCollaborator()) {
                collaboratorList.add(collaborator.getUsername());
            }
        }

        ArrayList<String> allTasks = new ArrayList<>();
        for (Task tempTask : currentUserService.getCurrentUser().getTasks()) {
            allTasks.add(tempTask.getName());
        }

        // Returning the response
        TaskInfoResponseModel response = new TaskInfoResponseModel(
                task.getName(),
                task.getDescription(),
                task.getCompleted(),
                tagList,
                eventList,
                collaboratorList,
                allTasks
        );
        return taskInfoPresenter.prepareSuccessView(response);
    }
}
