package entities;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Invitation implements InvitationInterface {
    public User toUser;
    public User fromUser;
    public String sentTime;

    public Task task;

    public Invitation(User toUser, User fromUser, Task task){
        this.toUser = toUser;
        this.fromUser = fromUser;
        this.sentTime = getSentTime();
        this.task = task;
    }

    @Override
    public User getSender(){return this.fromUser;}

    @Override
    public User getReceiver(){return this.toUser;}

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
}
