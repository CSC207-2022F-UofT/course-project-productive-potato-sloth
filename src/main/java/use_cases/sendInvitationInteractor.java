
package use_cases;

import entities.InvitationFactory;
import entities.User;
import entities.Invitation;

import java.time.LocalDateTime;


public class sendInvitationInteractor implements InvitationInputBoundary {

    final InvitationOutputBoundary presenter;

    final InvitationFactory invitationFactory;

    public sendInvitationInteractor(InvitationOutputBoundary presenter, InvitationFactory invitationFactory) {
        this.presenter = presenter;
        this.invitationFactory = invitationFactory;}

    @Override
    public InvitationOutputModel sendInvitation(InvitationInputModel inputModel){


        Invitation invitation = invitationFactory.create(inputModel.sender, inputModel.receiver, inputModel.task);

        inputModel.sender.addOutgoingInvitation(invitation); // add invitation
        inputModel.receiver.addIncomingInvitation(invitation); // add invitation

        LocalDateTime time = LocalDateTime.now();
        InvitationOutputModel outputModel = new InvitationOutputModel(invitation.getSender(), invitation.getReceiver(), invitation.getTask(), time.toString());
        return presenter.prepareSentView(outputModel);

    }
}