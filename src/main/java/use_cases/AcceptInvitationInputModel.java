package use_cases;

public class AcceptInvitationInputModel extends InvitationInputModel{

    boolean accept;

    public AcceptInvitationInputModel(User sender, User receiver, Task task, boolean accept) {
        super(sender, receiver, task);
        this.accept = accept;
    }

}
