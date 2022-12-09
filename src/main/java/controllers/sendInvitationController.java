package controllers;

import useCases.InvitationSending.InvitationInputBoundary;
import useCases.InvitationSending.InvitationInputModel;
import useCases.InvitationSending.InvitationOutputModel;

/**
 * * The controller responsible for calling the sendInvitationInteractor
 */
public class sendInvitationController {
    final InvitationInputBoundary userInput; // userInput is a use case that implements InvitationInputBoundary

    public sendInvitationController(InvitationInputBoundary userInput) {

        this.userInput = userInput; // initialize userInput with the passed-in interactor from Main
    }

    public InvitationOutputModel sendInvitationControllerMethod(String sender, String receiver, String task){// get sender, receiver, task from View and
        //wrap them in a requestModel object
        InvitationInputModel requestModel = new InvitationInputModel(
                sender, receiver, task);

        return userInput.sendInvitation(requestModel); // pass the object down to the interactor and call it's sendInvitation method
    }
}
