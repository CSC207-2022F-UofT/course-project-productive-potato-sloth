package controller;

import use_cases.AcceptInvitationInputBoundary;
import use_cases.AcceptInvitationOutputModel;
import use_cases.AcceptInvitationInputModel

public class acceptInvitationController {

    final AcceptInvitationInputBoundary userInput;

    public acceptInvitationController(AcceptInvitationInputBoundary userInput) {
        this.userInput = userInput;
    }

    AcceptInvitationOutputModel acceptInvitations(User sender, User receiver, Task task, boolean accept){
        AcceptInvitationInputModel requestModel = new AcceptInvitationInputModel(
                sender, receiver, task, accept);

        return userInput.acceptInvitations(requestModel);
    }

}
