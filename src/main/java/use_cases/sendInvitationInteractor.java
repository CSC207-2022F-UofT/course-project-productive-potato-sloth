
package use_cases;

import entities.InvitationFactory;
import entities.User;
import entities.Invitation;

public class sendInvitationInteractor implements InvitationInputBoundary {

    final InvitationOutputBoundary presenter;

    final InvitationFactory invitationFactory; //maybe?

    public sendInvitationInteractor(InvitationOutputBoundary presenter, InvitationFactory invitationFactory) {
        this.presenter = presenter;
        this.invitationFactory = invitationFactory;}

    @Override
    public InvitationOutputModel sendInvitation(InvitationInputModel inputModel){


        Invitation invitation = invitationFactory.create(inputModel.sender, inputModel.receiver, inputModel.task);
        // depends on how
        // changeOutgoingInvitations is implemented <=> may or may not use InvitationFactory here
        inputModel.sender.changeOutgoingInvitations(invitation); // add invitation
        inputModel.receiver.changeIncomingInvitations(invitation); // add invitation

        InvitationOutputModel outputModel = new InvitationOutputModel(invitation.getSender(), invitation.getReceiver(), invitation.getTask());
        return presenter.prepareSentView(outputModel);

    }
}