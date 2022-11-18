package use_cases;

import entities.Task;
import entities.User;

public class InvitationOutputModel extends InvitationInputModel{
    String timeSent;
    public InvitationOutputModel(User sender, User receiver, Task task, String time){
        super(sender, receiver, task);
        this.timeSent = time;}

    public String getTimeSent(){
        return this.timeSent;
    }
}
