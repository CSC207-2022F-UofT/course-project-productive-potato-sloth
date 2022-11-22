package entities.InvitationEntities;
import entities.Task;
import entities.User;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Invitation implements InvitationInterface {
    public User sender;
    public User receiver;
    public String sentTime;

    public Task task;

    public Invitation(User sender, User receiver, Task task){
        this.sender = sender;
        this.receiver = receiver;
        this.sentTime = getSentTime();
        this.task = task;
    }

    @Override
    public User getSender(){return this.sender;}

    @Override
    public User getReceiver(){return this.receiver;}

    @Override
    public String getSentTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    @Override
    public Task getTask(){
        return this.task;
    }

    @Override
    public void setTask(Task task){
        this.task = task;
    }

    @Override
    public void setSender(User sender){this.sender = sender;}

    @Override
    public void setReceiver(User receiver){this.receiver = sender;}

//    @Override
//    public String getSentTime(String str) {
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//        LocalDateTime now = LocalDateTime.now();
//        return dtf.format(now);
//    }                  -- to be implemented --


}
