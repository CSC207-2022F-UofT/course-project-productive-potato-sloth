package entities;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Invitation implements InvitationGetTimeInterface {
    public User toUser;
    public User fromUser;
    public String sentTime;

    public Invitation(User toUser, User fromUser){
        this.toUser = toUser;
        this.fromUser = fromUser;
        this.sentTime = getSentTime();
    }

    @Override
    public String getSentTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
}
