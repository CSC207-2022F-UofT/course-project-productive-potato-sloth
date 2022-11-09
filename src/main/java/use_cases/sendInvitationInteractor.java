package use_cases;

import entities.User;
import entities.Invitation;

public class sendInvitationInteractor {

    void sendInvitation(User sendingUser, User receivingUser){

        Invitation invitation = new Invitation(sendingUser, receivingUser);

        sendingUser.changeOutgoingInvitations(invitation); // add invitation
        receivingUser.changeIncomingInvitations(invitation); // add invitation

    }
    }

