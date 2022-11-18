package use_cases;


import entities.Task;
import entities.User;

public class InvitationInputModel {
    User sender;

    User receiver;

    Task task;

    public InvitationInputModel(User sender, User receiver, Task task){
        this.sender = sender;
        this.receiver = receiver;
        this.task = task;
}

    public User senderGetter(){return sender;}
    public void senderSetter(User sender){this.sender = sender;}

    public User receiverGetter(){return receiver;}
    public void receiverSetter(User receiver){this.receiver = receiver;}

    public Task taskGetter(){return task;}
    public void taskSetter(Task task ){this.task = task;}
}
