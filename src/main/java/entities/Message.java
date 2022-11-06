package entities;
import java.time.LocalDateTime;
public class Message {
    String content;
    String author;
    LocalDateTime timestamp;

    public Message(String content/*, *User user*/){
        this.content = content;
        /*this.author = user.getName;*/
        this.timestamp = LocalDateTime.now();
    }

}
