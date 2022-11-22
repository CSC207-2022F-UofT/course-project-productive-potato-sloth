package useCases.InvitationAcceptOrDecline;

import entities.InvitationEntities.InvitationFactory;
import entities.Task;
import entities.User;
import entities.InvitationEntities.Invitation;
import gateways.DataAccessInterface;

import java.time.LocalDateTime;

/**
 * Use case handling accept and reject (remove) invitations.
 */
public class acceptInvitationsInteractor implements AcceptInvitationInputBoundary {
    // accept an invitation means to take in the sender, receiver, task. Removes invitation from the
    // sender's outgoing list and the receiver's incoming list. Add the receiver to the task's
    // collaborators list
    final AcceptInvitationsOutputBoundary presenter;

    final InvitationFactory invitationFactory;

    final DataAccessInterface<User> UserDataBaseGateway;

    final DataAccessInterface<Task> TaskDataBaseGateway;

    public acceptInvitationsInteractor(AcceptInvitationsOutputBoundary presenter, InvitationFactory invitationFactory,
                                       DataAccessInterface<User> UserDataBaseGateway, DataAccessInterface<Task> TaskDataBaseGateway) {
        this.presenter = presenter;
        this.invitationFactory = invitationFactory;
        this.UserDataBaseGateway = UserDataBaseGateway;
        this.TaskDataBaseGateway = TaskDataBaseGateway;
    }


    @Override
    public void acceptInvitations(AcceptInvitationInputModel inputModel){

        User sender = UserDataBaseGateway.get(inputModel.senderGetter()); // get the sender from the database using the unique identifier
        User receiver = UserDataBaseGateway.get(inputModel.receiverGetter()); // get the receiver
        Task task = TaskDataBaseGateway.get(inputModel.taskGetter());// get the task

        Invitation invitation = invitationFactory.create(sender, receiver, task);

        //sender.removeOutgoingInvitation(invitation); // remove invitation
        //receiver.removeIncomingInvitation(invitation); // remove invitation

        if (inputModel.accept) {
            //task.addCollaborator(receiver); // call addCollaborator method of task
        } else {}

        LocalDateTime time = LocalDateTime.now();
        AcceptInvitationOutputModel outputModel = new AcceptInvitationOutputModel(inputModel.senderGetter(), inputModel.receiverGetter(), inputModel.taskGetter(), inputModel.accept, time.toString());
        presenter.prepareAcceptView(outputModel);
    }

}
