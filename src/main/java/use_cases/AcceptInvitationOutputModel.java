package use_cases;

public class AcceptInvitationOutputModel extends InvitationOutputModel{
    boolean accept;
    public AcceptInvitationOutputModel(User sender, User receiver, Task task, boolean accept) {
        super(sender, receiver, task);
        this.accept = accept;
    }
}
