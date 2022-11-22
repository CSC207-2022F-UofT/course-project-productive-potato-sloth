package InvitationcontrollerAndPresenter;

import useCases.InvitationSending.InvitationOutputModel;

/** The sendInvitationPresenter and the sendInvitationSuccessful view both depend on this interface
 * (the view implements this interface) */
public interface sendInvitationPresenterOutput {
    public void updateView(InvitationOutputModel outputModel);
}

