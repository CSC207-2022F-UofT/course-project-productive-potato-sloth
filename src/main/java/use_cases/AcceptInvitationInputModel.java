package use_cases;

import entities.Task;
import entities.User;

public class AcceptInvitationInputModel extends InvitationInputModel{

    boolean accept;

    public AcceptInvitationInputModel(User sender, User receiver, Task task, boolean accept) {
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
