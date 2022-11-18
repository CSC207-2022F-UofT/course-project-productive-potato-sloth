package controllerAndPresenter;

import use_cases.InvitationOutputBoundary;
import use_cases.InvitationOutputModel;

public class sendInvitationPresenter implements InvitationOutputBoundary {
    @Override
    public InvitationOutputModel prepareSentView(InvitationOutputModel outputModel) {
        return new InvitationOutputModel(outputModel.senderGetter(), outputModel.receiverGetter(), outputModel.taskGetter(), outputModel.getTimeSent());
    }
}


