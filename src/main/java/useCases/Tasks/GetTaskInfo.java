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

public class GetTaskInfo implements GetTaskInfoInputBoundary {

    TaskDataAccessInterface taskDatabaseGateway;
    TaskInfoPresenter taskInfoPresenter;
    CurrentUserService currentUserService;

    public GetTaskInfo(TaskDataAccessInterface taskDatabaseGateway, TaskInfoPresenter taskInfoPresenter, CurrentUserService currentUserService) {
        this.taskDatabaseGateway = taskDatabaseGateway;
        this.taskInfoPresenter = taskInfoPresenter;
        this.currentUserService = currentUserService;
    }

    @Override
    public TaskInfoResponseModel getInfo(TaskInfoRequestModel taskInfoRequestModel) {
        Task task = taskDatabaseGateway.get(taskInfoRequestModel.getName());

        ArrayList<String> tagList = new ArrayList<>();
        ArrayList<String> eventList = new ArrayList<>();
        ArrayList<String> collaboratorList = new ArrayList<>();

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
