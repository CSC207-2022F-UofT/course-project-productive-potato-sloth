package controllerAndPresenter;

import use_cases.AcceptInvitationOutputModel;
import use_cases.AcceptInvitationsOutputBoundary;
import use_cases.InvitationOutputModel;

public class acceptInvitationPresenter implements AcceptInvitationsOutputBoundary {

    acceptInvitationPresenterOutput view;

    public void acceptInvitationPresenter(acceptInvitationPresenterOutput view){this.view = view;} //inject the view (the screen) into the presenter
//    @Override
//    public AcceptInvitationOutputModel prepareAcceptView(AcceptInvitationOutputModel outputModel){
//        // implementation
//        return new AcceptInvitationOutputModel(outputModel.senderGetter(), outputModel.receiverGetter(), outputModel.taskGetter(), outputModel.acceptGetter(), outputModel.getTimeAccepted());
//    }
    @Override
    public void prepareAcceptView(AcceptInvitationOutputModel outputModel) {
        view.updateView(outputModel);

    }
}
