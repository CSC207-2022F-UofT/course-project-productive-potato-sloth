package presenters;

import useCases.InvitationAcceptOrDecline.AcceptInvitationOutputModel;
import useCases.InvitationAcceptOrDecline.AcceptInvitationsOutputBoundary;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class acceptInvitationPresenter implements AcceptInvitationsOutputBoundary {

    //acceptInvitationPresenterOutput view;

    //public void acceptInvitationPresenter(acceptInvitationPresenterOutput view){this.view = view;} //inject the view (the screen) into the presenter

    @Override
    public AcceptInvitationOutputModel prepareAcceptView(AcceptInvitationOutputModel outputModel) {
        LocalDateTime respondedTime = LocalDateTime.parse(outputModel.getTimeResponded());
        outputModel.setTimeResponded(respondedTime.format(DateTimeFormatter.ofPattern("hh:mm:ss"))); // reformat the timeResponded from the outputModel
        return outputModel; // send the sender, receiver, task, whether invitation is accepted, and reformatted timeResponded to the controller


    }
}
