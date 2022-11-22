package InvitationcontrollerAndPresenter;

import useCases.InvitationSending.InvitationOutputBoundary;
import useCases.InvitationSending.InvitationOutputModel;

/** sendInvitationPresenter which takes in a view and calls the view's update method */
public class sendInvitationPresenter implements InvitationOutputBoundary {

    sendInvitationPresenterOutput view;

    public void sendInvitationPresenter(sendInvitationPresenterOutput view){this.view = view;} //inject the view (the screen) into the presenter
    @Override
    public void prepareSentView(InvitationOutputModel outputModel) {
        view.updateView(outputModel);

    }
}


