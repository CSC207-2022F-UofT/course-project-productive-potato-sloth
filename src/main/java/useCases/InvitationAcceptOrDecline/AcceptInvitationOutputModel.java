package useCases.InvitationAcceptOrDecline;

public class AcceptInvitationOutputModel extends AcceptInvitationInputModel{
    String timeResponded;

    public AcceptInvitationOutputModel(String sender, String receiver, String task, boolean accept, String time) {
        super(sender, receiver, task, accept);
        this.timeResponded = time;

    }

    public String getTimeResponded(){
        return this.timeResponded;
    }
    public void setTimeResponded(String timeResponded){this.timeResponded = timeResponded;}
}
