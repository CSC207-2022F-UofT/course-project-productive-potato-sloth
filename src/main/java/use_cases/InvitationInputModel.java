package use_cases;


import entities.Task;
import entities.User;

public class InvitationInputModel {
    String sender;

    String receiver;

    String task;

    public InvitationInputModel(String sender, String receiver, String task){
        this.sender = sender;
        this.receiver = receiver;
        this.task = task;
}

    public String senderGetter(){return sender;}
    public void senderSetter(String sender){this.sender = sender;}

    public String receiverGetter(){return receiver;}
    public void receiverSetter(String receiver){this.receiver = receiver;}

    public String taskGetter(){return task;}
    public void taskSetter(String task ){this.task = task;}
}
