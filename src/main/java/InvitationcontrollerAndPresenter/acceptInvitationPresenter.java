package InvitationcontrollerAndPresenter;

import useCases.InvitationAcceptOrDecline.AcceptInvitationOutputModel;
import useCases.InvitationAcceptOrDecline.AcceptInvitationsOutputBoundary;

public class acceptInvitationPresenter implements AcceptInvitationsOutputBoundary {

    acceptInvitationPresenterOutput view;

    public void acceptInvitationPresenter(acceptInvitationPresenterOutput view){this.view = view;} //inject the view (the screen) into the presenter

    @Override
    public void prepareAcceptView(AcceptInvitationOutputModel outputModel) {
        view.updateView(outputModel);

    }
}
