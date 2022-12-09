package controllers;

import useCases.InvitationAcceptOrDecline.AcceptInvitationInputBoundary;
import useCases.InvitationAcceptOrDecline.AcceptInvitationInputModel;
import useCases.InvitationAcceptOrDecline.AcceptInvitationOutputModel;

public class acceptInvitationController {

    final AcceptInvitationInputBoundary userInput;

    public acceptInvitationController(AcceptInvitationInputBoundary userInput) {
        this.userInput = userInput;
    }

    public AcceptInvitationOutputModel acceptInvitations(String sender, String receiver, String task, boolean accept){
        AcceptInvitationInputModel requestModel = new AcceptInvitationInputModel(
                sender, receiver, task, accept);

        return userInput.acceptInvitations(requestModel);
    }

}
