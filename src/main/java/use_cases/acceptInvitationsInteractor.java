package use_cases;

import entities.InvitationFactory;
import entities.Task;
import entities.User;
import entities.Invitation;

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

    final DataAccessInterface UserDataBaseGateway;

    final DataAccessInterface TaskDataBaseGateway;

    public acceptInvitationsInteractor(AcceptInvitationsOutputBoundary presenter, InvitationFactory invitationFactory,
                                       DataAccessInterface UserDataBaseGateway, DataAccessInterface TaskDataBaseGateway) {
        this.presenter = presenter;
        this.invitationFactory = invitationFactory;
        this.UserDataBaseGateway = UserDataBaseGateway;
        this.TaskDataBaseGateway = TaskDataBaseGateway;
    }


    @Override
    public void acceptInvitations(AcceptInvitationInputModel inputModel){

        User sender = UserDataBaseGateway.get(inputModel.sender); // get the sender from the database using the unique identifier
        User receiver = UserDataBaseGateway.get(inputModel.receiver); // get the receiver
        Task task = TaskDataBaseGateway.get(inputModel.task);// get the task

        Invitation invitation = invitationFactory.create(sender, receiver, task);

        sender.removeOutgoingInvitation(invitation); // remove invitation
        receiver.removeIncomingInvitation(invitation); // remove invitation

        if (inputModel.accept) {
            task.addCollaborator(receiver); // call addCollaborator method of task
        } else {}

        LocalDateTime time = LocalDateTime.now();
        AcceptInvitationOutputModel outputModel = new AcceptInvitationOutputModel(inputModel.sender, inputModel.receiver, inputModel.task, inputModel.accept, time.toString());
        presenter.prepareAcceptView(outputModel);
    }

}
