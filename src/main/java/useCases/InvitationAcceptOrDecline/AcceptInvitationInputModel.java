package useCases.InvitationAcceptOrDecline;

import useCases.InvitationSending.InvitationInputModel;

public class AcceptInvitationInputModel extends InvitationInputModel {

    boolean accept;

    public AcceptInvitationInputModel(String sender, String receiver, String task, boolean accept) {
        super(sender, receiver, task);
        this.accept = accept;
    }
    public boolean acceptGetter(){
        return this.accept;
    };

    public void acceptSetter(boolean value){
        this.accept = value;
    };
}
