package controllerAndPresenter;

import use_cases.AcceptInvitationOutputModel;
import use_cases.AcceptInvitationsOutputBoundary;
import use_cases.InvitationOutputModel;

public class acceptInvitationPresenter implements AcceptInvitationsOutputBoundary {

    @Override
    public AcceptInvitationOutputModel prepareAcceptView(AcceptInvitationOutputModel outputModel){
        // implementation
        return new AcceptInvitationOutputModel(outputModel.senderGetter(), outputModel.receiverGetter(), outputModel.taskGetter(), outputModel.acceptGetter(), outputModel.getTimeAccepted());

    }
}
