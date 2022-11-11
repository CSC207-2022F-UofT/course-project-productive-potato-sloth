package use_cases;

public class InvitationInputModel {
    User sender;

    User receiver;

    Task task;

    public InvitationInputModel(User sender, User receiver, Task task){
        this.sender = sender;
        this.receiver = receiver;
        this.task = task;
}

    User senderGetter(){return sender;}
    void senderSetter(User sender){this.sender = sender;}

    User receiverGetter(){return receiver;}
    void receiverSetter(User receiver){this.receiver = receiver;}

    Task taskGetter(){return task;}
    void taskSetter(Task task ){this.task = task;}
}
