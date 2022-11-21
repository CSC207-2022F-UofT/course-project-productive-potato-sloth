package use_cases;

import entities.Task;
import entities.User;

public class AcceptInvitationOutputModel extends AcceptInvitationInputModel{
    String timeAccepted;

    public AcceptInvitationOutputModel(String sender, String receiver, String task, boolean accept, String time) {
        super(sender, receiver, task, accept);
        this.timeAccepted = time;

    }

    public String getTimeAccepted(){
        return this.timeAccepted;
    }
}
