package usecases;

import presenters.acceptInvitationPresenter;
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
import useCases.InvitationAcceptOrDecline.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class AcceptInvitationInteractorTest {

    @Test
    void accept_invitation_interactor_test() throws IOException {
        /**Create an acceptInvitationInteractor with appropriate constructor arguments such as
         * presenters, task- and user- database gateways...
         * Call the sendInvitation method of the interactor with the input data
         * test the presenter returns appropriate output data
         *
         * */

        /////////////////////////////////////////////////////////////// initialize necessary instances
        User mockUser = new User("sender", "password"); // sender
        User mockUser2 = new User("receiver", "password"); // receiver
        Task mockTask = new Task("task", mockUser); //current user is the receiver. Set the task to belong to the sender (not the current user)
        mockUser.addTask(mockTask);
        Invitation invitation = new Invitation(mockUser, mockUser2, mockTask);
        mockUser2.addIncomingInvitation(invitation); //receiver gets invitation added to their incoming list
        mockUser.addOutgoingInvitation(invitation); //sender gets invitation added to their outgoing list
        ///////////////////////////////////////////////////////////////


        CurrentUserService service = new CurrentUserService();

        service.setCurrentUser(mockUser2);

        DataAccessInterface<User> mockUserDatabaseGateway = new UserDatabaseGateway(
                "src/test/java/database/UserDatabaseMockFile2.ser");


        mockUserDatabaseGateway.insert(mockUser); // sender
        mockUserDatabaseGateway.insert(mockUser2); // receiver

        InvitationFactoryInterface mockInvitationFactory = new InvitationFactory();

        DataAccessInterface<Task> mockTaskDatabaseGateway = new TaskDatabaseGateway(service, (UserDatabaseGateway) mockUserDatabaseGateway);

        //mockTaskDatabaseGateway.insert(mockTask); //task


        // This creates an anonymous implementing class for the Output Boundary.
        AcceptInvitationsOutputBoundary presenter = new acceptInvitationPresenter() {

            @Override
            public AcceptInvitationOutputModel prepareAcceptView (AcceptInvitationOutputModel outputModel) {
                // 4) Check that the Output Data and associated changes
                // are correct
                assertEquals("sender", outputModel.senderGetter());
                assertEquals("receiver", outputModel.receiverGetter());
                assertEquals("task", outputModel.taskGetter());
                assertTrue(outputModel.acceptGetter());
                assertNotNull(outputModel.getTimeResponded()); // any creation time is valid.
                assertTrue(mockUser2.getIncomingInvitations().isEmpty()); //check the receiver has their incoming list emptied out after the interactor's done its job
                assertTrue(mockUser.getOutgoingInvitations().isEmpty()); //check the sender has their outgoing list emptied out after the interactor's done its job
                return null;
            }

        };


        AcceptInvitationInputBoundary acceptInvitationInteractor = new acceptInvitationsInteractor(presenter, mockInvitationFactory,
                mockUserDatabaseGateway, mockTaskDatabaseGateway);

        // 2) Input data — we can make this up for the test. Normally it would
        // be created by the Controller.
        AcceptInvitationInputModel inputData = new AcceptInvitationInputModel(
                "sender", "receiver", "task", true);

        // 3) Run the use case
        assert !mockUser2.getIncomingInvitations().isEmpty();
        assert !mockUser.getOutgoingInvitations().isEmpty();
        acceptInvitationInteractor.acceptInvitations(inputData);
    }
}
