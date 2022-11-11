package controller;

import use_cases.*;

public class sendInvitationController {
    final InvitationInputBoundary userInput;

    public sendInvitationController(InvitationInputBoundary userInput) {
        this.userInput = userInput;
    }

    InvitationOutputModel sendInvitation(User sender, User receiver, Task task){
        InvitationInputModel requestModel = new InvitationInputModel(
                sender, receiver, task);

        return userInput.sendInvitation(requestModel);
    }
}
