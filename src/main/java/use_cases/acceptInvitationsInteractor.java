package use_cases;

import entities.InvitationFactory;
import entities.User;
import entities.Invitation;

public class acceptInvitationsInteractor implements AcceptInvitationInputBoundary {
    // accept an invitation means to take in the sender, receiver, task. Removes invitation from the
    // sender's outgoing list and the receiver's incoming list. Add the receiver to the task's
    // collaborators list
    final AcceptInvitationsOutputBoundary presenter;

    final InvitationFactory invitationFactory; //maybe?

    public acceptInvitationsInteractor(AcceptInvitationsOutputBoundary presenter, InvitationFactory invitationFactory) {
        this.presenter = presenter;
        this.invitationFactory = invitationFactory;
    }


    @Override
    public AcceptInvitationOutputModel acceptInvitations(AcceptInvitationInputModel inputModel){

        Invitation invitation = invitationFactory.create(inputModel.sender, inputModel.receiver, inputModel.task);
        // depends on how
        // changeOutgoingInvitations is implemented <=> may or may not use InvitationFactory here
        inputModel.sender.changeOutgoingInvitations(invitation); // remove invitation
        inputModel.receiver.changeIncomingInvitations(invitation); // remove invitation

        if (inputModel.accept) {
            inputModel.task.addCollaborator(inputModel.receiver);
        } else {}


        AcceptInvitationOutputModel outputModel = new AcceptInvitationOutputModel(invitation.getSender(), invitation.getReceiver(), invitation.getTask(), inputModel.accept);
        return presenter.prepareAcceptView(outputModel);
    }

}
