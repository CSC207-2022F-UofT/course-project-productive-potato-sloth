package usecases;

import presenters.sendInvitationPresenter;
import entities.InvitationEntities.Invitation;
import entities.InvitationEntities.InvitationFactory;
import entities.InvitationEntities.InvitationFactoryInterface;
import entities.Task;
import entities.User;
import gateways.DataAccessInterface;
import gateways.TaskDatabaseGateway;
import gateways.UserDatabaseGateway;
import org.junit.jupiter.api.Test;
import services.CurrentUserService;
import useCases.InvitationSending.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


public class SendInvitationInteractorTest {
    @Test
    void send_invitation_interactor_test() throws IOException {


        /**Create a sendInvitationInteractor with appropriate constructor arguments such as
         * presenters, task- and user- database gateways...
         * Call the sendInvitation method of the interactor with the input data
         * test the presenter returns appropriate output data
         *
         * */

        ///////////////////////////////////////////// initialize relevant objects
        User mockUser = new User("sender", "password"); //sender
        User mockUser2 = new User("receiver", "password"); //receiver
        Task mockTask = new Task("test", mockUser);
        Invitation invitation = new Invitation(mockUser, mockUser2, mockTask);
        ////////////////////////////////////////////

        CurrentUserService service = new CurrentUserService();

        service.setCurrentUser(mockUser);

        DataAccessInterface<User> mockUserDatabaseGateway = new UserDatabaseGateway(
                "src/test/java/database/UserDatabaseMockFile.ser");

        mockUserDatabaseGateway.insert(mockUser); // sender
        mockUserDatabaseGateway.insert(mockUser2); // receiver


        InvitationFactoryInterface mockInvitationFactory = new InvitationFactory();

        DataAccessInterface<Task> mockTaskDatabaseGateway = new TaskDatabaseGateway(service, (UserDatabaseGateway) mockUserDatabaseGateway);

        // This creates an anonymous implementing class for the Output Boundary.
        InvitationOutputBoundary presenter = new sendInvitationPresenter() {

            @Override
            public InvitationOutputModel prepareSentView (InvitationOutputModel outputModel) {
                // 4) Check that the Output Data and associated changes
                // are correct
                assertEquals("sender", outputModel.senderGetter());
                assertEquals("receiver", outputModel.receiverGetter());
                assertEquals("task", outputModel.taskGetter());
                assertNotNull(outputModel.getTimeSent()); // checks if a creation time exists.
                assertFalse(mockUser.getOutgoingInvitations().isEmpty());
                assertEquals("receiver", mockUser2.getIncomingInvitations().get(0).getReceiver().getUsername());
                return null;
            }

        };


        InvitationInputBoundary sendInvitationInteractor = new sendInvitationInteractor(presenter, mockInvitationFactory,
                mockUserDatabaseGateway, mockTaskDatabaseGateway);

        // 2) Input data — we can make this up for the test. Normally it would
        // be created by the Controller.
        InvitationInputModel inputData = new InvitationInputModel(
                "sender", "receiver", "task");

        // 3) Run the use case
        sendInvitationInteractor.sendInvitation(inputData);
    }


}
