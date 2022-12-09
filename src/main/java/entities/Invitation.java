package entities;

import entities.InvitationInterface;
import entities.Task;
import entities.User;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Invitation implements Serializable, InvitationInterface {

    private static final long serialVersionUID = 6529685098267757692L;
    public User sender;
    public User receiver;
    transient String sentTime;

    public Task task;


    public Invitation(User sender, User receiver, Task task){
        this.sender = sender;
        this.receiver = receiver;
        this.sentTime = getSentTime();
        this.task = task;
    }

    public User getSender(){return this.sender;}

    public User getReceiver(){return this.receiver;}

    public String getSentTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public Task getTask(){
        return this.task;
    }

    public void setTask(Task task){
        this.task = task;
    }

    public void setSender(User sender){this.sender = sender;}

    public void setReceiver(User receiver){this.receiver = receiver;}


}