import controllers.Tags.*;
import controllers.Tasks.*;
import entities.*;
import gateways.Tags.TagDataAccessInterface;
import gateways.Tags.TagDatabaseGateway;
import gateways.Tasks.TaskDataAccessInterface;
import gateways.Tasks.TaskDatabaseGateway;
import gateways.UserDatabaseGateway;
import presenters.*;
import screens.TaskList.*;
import screens.ViewCalendar.ViewCalendarMainFrame;
import screens.WelcomeScreen;
import services.CurrentUserService;
import useCases.Tags.*;
import useCases.Tasks.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class Main {

    static User user = new User("User", "Password");

    public static void main(String[] args) throws IOException {

        // Instantiating all Factories
        TaskFactory taskFactory = new TaskFactory();
        TagFactory tagFactory = new TagFactory();

        // Instantiating all Presenters
        TaskPresenter taskPresenter = new TaskResponseFormatter();
        TaskInfoPresenter taskInfoPresenter = new TaskInfoResponseFormatter();
        TagPresenter tagPresenter = new TagResponseFormatter();

        // Instantiating all Services
        CurrentUserService currentUserService = new CurrentUserService();

        // Instantiating all Database Gateways
        UserDatabaseGateway userDatabaseGateway = new UserDatabaseGateway("testDatabase.ser");

        User user = userDatabaseGateway.get("User");
        if (user == null) {
            user = new User("user", "password");
        }
        currentUserService.setCurrentUser(user);

        TagDataAccessInterface tagDatabaseGateway = new TagDatabaseGateway(currentUserService, userDatabaseGateway);
        TaskDataAccessInterface taskDataAccessInterface = new TaskDatabaseGateway(currentUserService, userDatabaseGateway);


        // Instantiating all Input Boundaries
        CreateTagInputBoundary createTagInteractor = new CreateTag(tagDatabaseGateway, userDatabaseGateway, tagFactory, tagPresenter, currentUserService);
        DeleteTagInputBoundary deleteTagInteractor = new DeleteTag(tagDatabaseGateway, tagPresenter);
        EditTagInputBoundary editTagInteractor = new EditTag(tagDatabaseGateway, tagPresenter);
        GetTaskInfoInputBoundary getTaskInfoInputBoundary = new GetTaskInfo(taskDataAccessInterface, taskInfoPresenter, currentUserService);
        GetTagsInputBoundary getTagsInputBoundary = new GetTags(tagDatabaseGateway, taskInfoPresenter, currentUserService);

        AddCollaboratorInputBoundary addCollaboratorInteractor = new AddCollaborator(taskDataAccessInterface, userDatabaseGateway, taskPresenter);
        AddTagInputBoundary addTagInteractor = new AddTag(taskDataAccessInterface, tagDatabaseGateway, taskPresenter);
        CreateTaskInputBoundary createTaskInteractor = new CreateTask(taskDataAccessInterface, userDatabaseGateway, currentUserService, taskFactory, taskPresenter);
        EditTaskInputBoundary editTaskInteractor = new EditTask(taskDataAccessInterface, taskPresenter);
        MarkTaskCompletenessInputBoundary markTaskCompletenessInteractor = new MarkTaskCompleteness(taskDataAccessInterface, taskPresenter);
        RemoveCollaboratorInputBoundary removeCollaboratorInteractor = new RemoveCollaborator(taskDataAccessInterface, userDatabaseGateway, taskPresenter);
        RemoveTagInputBoundary removeTagInteractor = new RemoveTag(taskDataAccessInterface, tagDatabaseGateway, taskPresenter);
        RemoveTaskInputBoundary removeTaskInteractor = new RemoveTask(taskDataAccessInterface, taskPresenter);

        // Instantiating all Controllers
        CreateTagController createTagController = new CreateTagController(createTagInteractor);
        DeleteTagController deleteTagController = new DeleteTagController(deleteTagInteractor);
        EditTagColorController editTagColorController = new EditTagColorController(editTagInteractor);
        EditTagNameController editTagNameController = new EditTagNameController(editTagInteractor);
        GetTaskInfoController getTaskInfoController = new GetTaskInfoController(getTaskInfoInputBoundary);
        GetTagsController getTagsController = new GetTagsController(getTagsInputBoundary);

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

        // Instantiating all Screens
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

        DeleteTaskConfirmationDialog deleteTaskConfirmationDialog = new DeleteTaskConfirmationDialog(
                removeTaskController,
                getTaskInfoController
        );

        DeleteTaskPopUp deleteTaskPopUp = new DeleteTaskPopUp(
                deleteTaskConfirmationDialog
        );

        NewTagScreen newTagScreen = new NewTagScreen(
                getTagsController,
                createTagController
        );

        DeleteTagConfirmationDialogue deleteTagConfirmationDialogue = new DeleteTagConfirmationDialogue(deleteTagController, getTagsController);

        EditTagScreen editTagScreen = new EditTagScreen(editTagNameController, getTagsController);

        DeleteEditTagPopUp deleteTagPopUp = new DeleteEditTagPopUp(deleteTagConfirmationDialogue, editTagScreen);

        TagScreen tagScreen = new TagScreen(
                getTagsController,
                currentUserService,
                newTagScreen,
                deleteTagPopUp,
                editTagScreen
        );

        TaskListScreen taskListScreen = new TaskListScreen(
                viewModel,
                getTaskInfoController,
                removeTaskController,
                taskScreen,
                tagScreen,
                newTaskScreen,
                deleteTaskPopUp
        );

        // Registering all required Observers to their Subjects
        taskEditScreen.registerObserver(taskScreen);
        taskEditScreen.registerObserver(taskListScreen);
        newTaskScreen.registerObserver(taskListScreen);
        deleteTaskConfirmationDialog.registerObserver(taskListScreen);
        newTagScreen.registerObserver(tagScreen);
        deleteTagConfirmationDialogue.registerObserver(tagScreen);
        editTagScreen.registerObserver(tagScreen);


        // Setup the view calendar use case

        ViewCalendarMainFrame viewCalendarMainFrame = new ViewCalendarMainFrame(currentUserService, userDatabaseGateway);


        WelcomeScreen applicationFrame = new WelcomeScreen(taskListScreen, currentUserService, viewCalendarMainFrame);

        // everyone add your buttons and action listener in the WelcomeScreen class

        applicationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        applicationFrame.pack();
        applicationFrame.setVisible(true);

    }

    public static void setupTestData() {
        // This is temporary test data
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
    }

}