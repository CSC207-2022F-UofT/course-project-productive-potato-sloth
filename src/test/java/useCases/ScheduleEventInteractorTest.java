package useCases;

import entities.Tag;
import entities.Task;
import entities.User;
import gateways.UserDataAccessInterface;
import gateways.UserDatabaseGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import screens.ScheduleEvent.EventCreationFailed;
import screens.ScheduleEvent.ScheduleEventResponseModel;
import services.CurrentUserService;
import useCases.ScheduleEvent.ScheduleEventInteractor;
import useCases.ScheduleEvent.ScheduleEventPresenter;
import useCases.ScheduleEvent.ScheduleEventRequestModel;
import useCases.ScheduleEvent.ScheduleEventResponseFormatter;

import java.awt.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ScheduleEventInteractorTest {

    CurrentUserService currentUserService;
    UserDataAccessInterface gateway;

    Task task;

    @BeforeEach
    /**
     * Setup a default CurrentUserService and a gateway.
     * Set it up with some default tags and tasks.
     */
    public void setup() throws IOException {
        currentUserService = new CurrentUserService();
        User testUser = new User("testUsername", "testPassword");

        Tag tag1 = new Tag("csc207", Color.RED, testUser);
        Tag tag2 = new Tag("coursework", Color.BLACK, testUser);
        Tag tag3 = new Tag("academics", Color.BLUE, testUser);
        Tag tag4 = new Tag("lifestyle", Color.BLUE, testUser);
        testUser.addTag(tag1);
        testUser.addTag(tag2);
        testUser.addTag(tag3);
        testUser.addTag(tag4);

        Task task1 = new Task("Acquire Relationship", testUser);
        Task task2 = new Task("CSC207 Project", testUser);
        Task task3 = new Task("Self-Actualize", testUser);
        Task task4 = new Task("Impress Derek", testUser);
        testUser.addTask(task1);
        testUser.addTask(task2);
        testUser.addTask(task3);
        testUser.addTask(task4);

        currentUserService.setCurrentUser(testUser);

        gateway = new UserDatabaseGateway("data_files/emptyUserFile.ser");
    }

    @Test
    /**
     * Test scheduling an event with certain creation parameters, which is expected to fail due
     * to the task not being found.
     */
    public void testScheduleEventNoStartDate() {
        ScheduleEventPresenter presenter = new ScheduleEventResponseFormatter();
        ScheduleEventInteractor interactor = new ScheduleEventInteractor(currentUserService, presenter, gateway);

        LocalDateTime start_time = LocalDateTime.of(2022, 11, 9, 23, 22);
        LocalDateTime end_time = LocalDateTime.of(2022, 10, 9, 23, 22);
        ArrayList<String> tagNames = new ArrayList<>();
        tagNames.add("csc207");
        tagNames.add("coursework");
        ScheduleEventRequestModel requestModel = new ScheduleEventRequestModel(
                "Test Event",
                start_time,
                end_time,
                "Depress Derek",
                tagNames
        );

        try{
            ScheduleEventResponseModel responseModel = interactor.scheduleEvent(
                    requestModel
            );
        }catch(EventCreationFailed e){
            assert e.getMessage().equals("No task with the given name exists.");
        }
    }


    @Test
    /**
     * Test scheduling an event with certain creation parameters, which is expected to fail due
     * to the end date not being present.
     */
    public void testScheduleEventNoEndDate() {
        ScheduleEventPresenter presenter = new ScheduleEventResponseFormatter();
        ScheduleEventInteractor interactor = new ScheduleEventInteractor(currentUserService, presenter, gateway);

        LocalDateTime start_time = LocalDateTime.of(2022, 11, 9, 23, 22);
//        LocalDateTime end_time = LocalDateTime.of(2022, 10, 9, 23, 22);
        ArrayList<String> tagNames = new ArrayList<>();
        tagNames.add("csc207");
        tagNames.add("coursework");
        ScheduleEventRequestModel requestModel = new ScheduleEventRequestModel(
                "Test Event",
                start_time,
                null,
                "Impress Derek",
                tagNames
        );

        try{
            ScheduleEventResponseModel responseModel = interactor.scheduleEvent(
                    requestModel
            );
        }catch(EventCreationFailed e){
            assert e.getMessage().equals("No end time provided.");
        }
    }


    @ParameterizedTest
    /**
     * Test scheduling an event with certain creation parameters, which is expected to fail due
     * to the event name being blank.
     * @param name
     */
    @ValueSource(strings = {" ", "   ", "", "   "})
    public void testScheduleEventEmptyName(String name) {
        ScheduleEventPresenter presenter = new ScheduleEventResponseFormatter();
        ScheduleEventInteractor interactor = new ScheduleEventInteractor(currentUserService, presenter, gateway);

        LocalDateTime start_time = LocalDateTime.of(2022, 11, 9, 23, 22);
        LocalDateTime end_time = LocalDateTime.of(2022, 10, 9, 23, 22);
        ArrayList<String> tagNames = new ArrayList<>();
        tagNames.add("csc207");
        tagNames.add("coursework");
        ScheduleEventRequestModel requestModel = new ScheduleEventRequestModel(
                "  ",
                start_time,
                end_time,
                "Impress Derek",
                tagNames
        );

        try{
            ScheduleEventResponseModel responseModel = interactor.scheduleEvent(
                    requestModel
            );
        }catch(EventCreationFailed e){
            assert e.getMessage().equals("Your event name must not be empty.");
        }
    }


    @Test
    /**
     * Test scheduling an event with certain creation parameters, which is expected to fail due
     * to the start date not being present.
     */
    public void testScheduleEventBadTaskName() {
        ScheduleEventPresenter presenter = new ScheduleEventResponseFormatter();
        ScheduleEventInteractor interactor = new ScheduleEventInteractor(currentUserService, presenter, gateway);

//        LocalDateTime start_time = LocalDateTime.of(2022, 11, 9, 23, 22);
        LocalDateTime end_time = LocalDateTime.of(2022, 10, 9, 23, 22);
        ArrayList<String> tagNames = new ArrayList<>();
        tagNames.add("csc207");
        tagNames.add("coursework");
        ScheduleEventRequestModel requestModel = new ScheduleEventRequestModel(
                "Test Event",
                null,
                end_time,
                "Impress Derek",
                tagNames
        );

        try{
            ScheduleEventResponseModel responseModel = interactor.scheduleEvent(
                    requestModel
            );
        }catch(EventCreationFailed e){
            assert e.getMessage().equals("No start time provided.");
        }
    }


    @Test
    /**
     * Test scheduling an event with certain creation parameters, which is expected to fail due
     * to the end date being after the start date.
     */
    public void testScheduleEventEndsAfterStarts() {
        ScheduleEventPresenter presenter = new ScheduleEventResponseFormatter();
        ScheduleEventInteractor interactor = new ScheduleEventInteractor(currentUserService, presenter, gateway);

        LocalDateTime start_time = LocalDateTime.of(2022, 11, 9, 23, 22);
        LocalDateTime end_time = LocalDateTime.of(2022, 10, 9, 23, 22);
        ArrayList<String> tagNames = new ArrayList<>();
        tagNames.add("csc207");
        tagNames.add("coursework");
        ScheduleEventRequestModel requestModel = new ScheduleEventRequestModel(
                "Test Event",
                start_time,
                end_time,
                "Impress Derek",
                tagNames
        );

        try{
            ScheduleEventResponseModel responseModel = interactor.scheduleEvent(
                    requestModel
            );
        }catch(EventCreationFailed e){
            assert e.getMessage().equals("The event must end after it begins.");
        }
    }

    @Test
    /**
     * Test scheduling an event with certain creation parameters, which is expected to succeed.
     */
    public void testScheduleEventSuccess() {
        ScheduleEventPresenter presenter = new ScheduleEventResponseFormatter();
        ScheduleEventInteractor interactor = new ScheduleEventInteractor(currentUserService, presenter, gateway);

        LocalDateTime start_time = LocalDateTime.of(2022, 11, 9, 23, 22);
        LocalDateTime end_time = LocalDateTime.of(2022, 11, 9, 23, 22);
        ArrayList<String> tagNames = new ArrayList<>();
        tagNames.add("csc207");
        tagNames.add("coursework");
        ScheduleEventRequestModel requestModel = new ScheduleEventRequestModel(
                "Test Event",
                start_time,
                end_time,
                "Impress Derek",
                tagNames
        );

        ScheduleEventResponseModel responseModel = interactor.scheduleEvent(
                requestModel
        );

        assert responseModel.getEventName().equals("Test Event");
    }
}
