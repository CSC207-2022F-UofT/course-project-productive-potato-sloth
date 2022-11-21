package controllerAndPresenter;

import entities.Task;
import entities.User;
import use_cases.AcceptInvitationInputBoundary;
import use_cases.AcceptInvitationOutputModel;
import use_cases.AcceptInvitationInputModel;

public class acceptInvitationController {

    final AcceptInvitationInputBoundary userInput;

    public acceptInvitationController(AcceptInvitationInputBoundary userInput) {
        this.userInput = userInput;
    }

    public void acceptInvitations(String sender, String receiver, String task, boolean accept){
        AcceptInvitationInputModel requestModel = new AcceptInvitationInputModel(
                sender, receiver, task, accept);

        userInput.acceptInvitations(requestModel);
    }

}
