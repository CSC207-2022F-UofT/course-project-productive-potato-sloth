import controllers.Tags.CreateTagController;
import controllers.Tags.DeleteTagController;
import controllers.Tags.EditTagColorController;
import controllers.Tags.EditTagNameController;
import controllers.Tasks.*;
import entities.*;
import gateways.Tags.TagDataAccessInterface;
import gateways.Tags.TagDatabaseGateway;
import gateways.Tasks.TaskDataAccessInterface;
import gateways.Tasks.TaskDatabaseGateway;
import gateways.UserDatabaseGateway;
import presenters.TaskInfoPresenter;
import presenters.TaskInfoResponseFormatter;
import presenters.TaskPresenter;
import presenters.TaskResponseFormatter;
import screens.TaskList.*;
import services.CurrentUserService;
import useCases.Tags.*;
import useCases.Tasks.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class TaskListMain {

    int clicks = 0;

    JLabel label;
    User user;


    public TaskListMain() throws IOException {

        user = new User();
        User collaborator = new User("collaborator", "collaborator");
        User collaborator2 = new User("collaborator2", "collaborator2");
        Task task1 = new Task("task1", user);
        Task task2 = new Task("task2", user, "description");
        Tag tag1 = new Tag("tag1", Color.RED, user);
        Tag tag2 = new Tag("tag2", Color.RED, user);
        task2.addTag(tag2);
        user.addTask(task1);
        user.addTask(task2);
        user.addTag(tag1);
        user.addTag(tag2);
        task1.addCollaborator(collaborator);
        task1.addCollaborator(collaborator2);


        TaskFactory taskFactory = new TaskFactory();
        TagFactory tagFactory = new TagFactory();

        TaskPresenter taskPresenter = new TaskResponseFormatter();
        TaskInfoPresenter taskInfoPresenter = new TaskInfoResponseFormatter();

        CurrentUserService currentUserService = new CurrentUserService();
        currentUserService.setCurrentUser(user);

        UserDatabaseGateway userDatabaseGateway = new UserDatabaseGateway("testDatabase.ser");
        TagDataAccessInterface tagDatabaseGateway = new TagDatabaseGateway(currentUserService, userDatabaseGateway);
        TaskDataAccessInterface taskDataAccessInterface = new TaskDatabaseGateway(currentUserService, userDatabaseGateway);

        CreateTagInputBoundary createTagInteractor = new CreateTag(tagDatabaseGateway, userDatabaseGateway, tagFactory);
        DeleteTagInputBoundary deleteTagInteractor = new DeleteTag(tagDatabaseGateway);
        EditTagInputBoundary editTagInteractor = new EditTag(tagDatabaseGateway);
        GetTaskInfoInputBoundary getTaskInfoInputBoundary = new GetTaskInfo(taskDataAccessInterface, taskInfoPresenter, currentUserService);

        AddCollaboratorInputBoundary addCollaboratorInteractor = new AddCollaborator(taskDataAccessInterface, userDatabaseGateway, taskPresenter);
        AddTagInputBoundary addTagInteractor = new AddTag(taskDataAccessInterface, tagDatabaseGateway, taskPresenter);
        CreateTaskInputBoundary createTaskInteractor = new CreateTask(taskDataAccessInterface, userDatabaseGateway, currentUserService, taskFactory, taskPresenter);
        EditTaskInputBoundary editTaskInteractor = new EditTask(taskDataAccessInterface, taskPresenter);
        MarkTaskCompletenessInputBoundary markTaskCompletenessInteractor = new MarkTaskCompleteness(taskDataAccessInterface, taskPresenter);
        RemoveCollaboratorInputBoundary removeCollaboratorInteractor = new RemoveCollaborator(taskDataAccessInterface, userDatabaseGateway, taskPresenter);
        RemoveTagInputBoundary removeTagInteractor = new RemoveTag(taskDataAccessInterface, tagDatabaseGateway, taskPresenter);
        RemoveTaskInputBoundary removeTaskInteractor = new RemoveTask(taskDataAccessInterface, taskPresenter);


        CreateTagController createTagController = new CreateTagController(createTagInteractor);
        DeleteTagController deleteTagController = new DeleteTagController(deleteTagInteractor);
        EditTagColorController editTagColorController = new EditTagColorController(editTagInteractor);
        EditTagNameController editTagNameController = new EditTagNameController(editTagInteractor);
        GetTaskInfoController getTaskInfoController = new GetTaskInfoController(getTaskInfoInputBoundary);

        AddCollaboratorController addCollaboratorController = new AddCollaboratorController(addCollaboratorInteractor);
        AddTagController addTagController = new AddTagController(addTagInteractor);
        CreateTaskController createTaskController = new CreateTaskController(createTaskInteractor);
        EditTaskNameController editTaskNameController = new EditTaskNameController(editTaskInteractor);
        EditTaskDescriptionController editTaskDescriptionController = new EditTaskDescriptionController(editTaskInteractor);
        MarkTaskCompletenessController markTaskCompletenessController = new MarkTaskCompletenessController(markTaskCompletenessInteractor);
        RemoveCollaboratorController removeCollaboratorController = new RemoveCollaboratorController(removeCollaboratorInteractor);
        RemoveTagController removeTagController = new RemoveTagController(removeTagInteractor);
        RemoveTaskController removeTaskController = new RemoveTaskController(removeTaskInteractor);


        TaskListViewModel viewModel = new TaskListViewModel();
        for (Task task : currentUserService.getCurrentUser().getTasks()) {
            viewModel.addTask(task.getName());
        }
        for (Tag tag : currentUserService.getCurrentUser().getTags()) {
            viewModel.addTag(tag.getName());
        }

        TaskEditScreen taskEditScreen = new TaskEditScreen(
                currentUserService,
                getTaskInfoController,
                addCollaboratorController,
                addTagController,
                editTaskDescriptionController,
                editTaskNameController,
                markTaskCompletenessController,
                removeCollaboratorController,
                removeTagController
        );

        TaskScreen taskScreen = new TaskScreen(
                viewModel,
                getTaskInfoController,
                taskEditScreen
        );

        NewTaskScreen newTaskScreen = new NewTaskScreen(
                getTaskInfoController,
                createTaskController
        );

        DeleteTaskConfirmationDialog deleteTaskConfirmationDialog = new DeleteTaskConfirmationDialog(removeTaskController, getTaskInfoController);


        DeleteTaskPopUp deleteTaskPopUp = new DeleteTaskPopUp(deleteTaskConfirmationDialog);

        TaskListScreen taskListScreen = new TaskListScreen(
                viewModel,
                getTaskInfoController,
                removeTaskController,
                taskScreen,
                newTaskScreen,
                deleteTaskPopUp
        );

        taskEditScreen.registerObserver(taskScreen);
        taskEditScreen.registerObserver(taskListScreen);
        newTaskScreen.registerObserver(taskListScreen);
        deleteTaskConfirmationDialog.registerObserver(taskListScreen);

    }

    public static void main(String[] args) throws IOException {
        new TaskListMain();

    }

}

