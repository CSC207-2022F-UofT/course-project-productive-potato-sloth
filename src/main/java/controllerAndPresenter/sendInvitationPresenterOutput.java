package controllerAndPresenter;

import use_cases.InvitationOutputModel;

/** The sendInvitationPresenter and the sendInvitationSuccessful view both depend on this interface */
public interface sendInvitationPresenterOutput {
    public void updateView(InvitationOutputModel outputModel);
}

