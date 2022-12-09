package presenters;

import useCases.InvitationSending.InvitationInputModel;
import useCases.InvitationSending.InvitationOutputBoundary;
import useCases.InvitationSending.InvitationOutputModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class sendInvitationPresenter implements InvitationOutputBoundary {

    //sendInvitationPresenterOutput view;

    // public void sendInvitationPresenter(sendInvitationPresenterOutput view){this.view = view;} //inject the view (the screen) into the presenter

    public InvitationOutputModel prepareSentView(InvitationOutputModel outputModel) {
        LocalDateTime sentTime = LocalDateTime.parse(outputModel.getTimeSent());
        outputModel.setTimeSent(sentTime.format(DateTimeFormatter.ofPattern("hh:mm:ss"))); // reformat the timeSent from the outputModel
        return outputModel; // send the sender, receiver, task, and reformatted timeSent to the controller

    }
}


