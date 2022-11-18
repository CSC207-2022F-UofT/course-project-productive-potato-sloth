package use_cases;

import entities.InvitationFactory;
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

    public acceptInvitationsInteractor(AcceptInvitationsOutputBoundary presenter, InvitationFactory invitationFactory) {
        this.presenter = presenter;
        this.invitationFactory = invitationFactory;
    }


    @Override
    public AcceptInvitationOutputModel acceptInvitations(AcceptInvitationInputModel inputModel){

        Invitation invitation = invitationFactory.create(inputModel.sender, inputModel.receiver, inputModel.task);

        inputModel.sender.removeOutgoingInvitation(invitation); // remove invitation
        inputModel.receiver.removeIncomingInvitation(invitation); // remove invitation

        if (inputModel.accept) {
            inputModel.task.addCollaborator(inputModel.receiver); // call addCollaborator method of task
        } else {}

        LocalDateTime time = LocalDateTime.now();
        AcceptInvitationOutputModel outputModel = new AcceptInvitationOutputModel(invitation.getSender(), invitation.getReceiver(), invitation.getTask(), inputModel.accept, time.toString());
        return presenter.prepareAcceptView(outputModel);
    }

}
