package use_cases;
import entities.User;
import entities.Invitation;

public class removeInvitationsInteractor {

    void removeInvitations(User sender, User receiver, Invitation invitation){

        sender.changeOutgoingInvitations(invitation); // remove invitation
        receiver.changeIncomingInvitations(invitation); // remove invitation
    }
}
