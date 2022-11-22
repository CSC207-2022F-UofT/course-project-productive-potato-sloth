
package useCases.InvitationSending;

import entities.InvitationEntities.InvitationFactory;
import entities.Task;
import entities.User;
import entities.InvitationEntities.Invitation;
import gateways.DataAccessInterface;

import java.time.LocalDateTime;


public class sendInvitationInteractor implements InvitationInputBoundary {

    final InvitationOutputBoundary presenter;

    final InvitationFactory invitationFactory;

    final DataAccessInterface<User> UserDataBaseGateway;

    final DataAccessInterface<Task> TaskDatabaseGateway;



    public sendInvitationInteractor(InvitationOutputBoundary presenter, InvitationFactory invitationFactory,
    DataAccessInterface<User> UserDataBaseGateway, DataAccessInterface<Task> TaskDatabaseGateway ) {
        this.presenter = presenter;
        this.invitationFactory = invitationFactory;
        this.UserDataBaseGateway = UserDataBaseGateway;
        this.TaskDatabaseGateway = TaskDatabaseGateway;}

    @Override
    public void sendInvitation(InvitationInputModel inputModel){

        User sender = UserDataBaseGateway.get(inputModel.sender); // get the sender from the database using the unique identifier
        User receiver = UserDataBaseGateway.get(inputModel.receiver); // get the receiver
        Task task = TaskDatabaseGateway.get(inputModel.task);// get the task
        Invitation invitation = invitationFactory.create(sender, receiver, task); //creates an invitation object

        //sender.addOutgoingInvitation(invitation); // add invitation to the sender's outgoing invitations list
        //receiver.addIncomingInvitation(invitation); // add invitation to the receiver's incoming invitations list

        LocalDateTime time = LocalDateTime.now(); // get the current time to pass in the output model to display in view
        InvitationOutputModel outputModel = new InvitationOutputModel(inputModel.sender, inputModel.receiver,
                inputModel.task, time.toString());
        presenter.prepareSentView(outputModel);

    }
}