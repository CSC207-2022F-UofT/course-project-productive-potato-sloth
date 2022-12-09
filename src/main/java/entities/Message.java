package entities;
import java.time.LocalDateTime;
import java.io.Serializable;
public class Message implements Serializable{
    String content;
    User author;
    LocalDateTime timestamp;

    /**
     * A Message is an entity containing a String (the message itself), the timestamp (when the message was
     * sent), and a reference to the User who sent it.
     * @param content: String, contents of message
     * @param user: User entity, representing user who sent the message
     */
    public Message(String content, User user){
        this.content = content;
        this.author = user;
        this.timestamp = LocalDateTime.now();
    }

    /**Below are the setter and getter methods.
     *
     * Overriding the toString method may be the most convenient way of getting the message text.*/
    @Override
    public String toString(){
        return this.content;
    }

    /**This method sets the content string to a new string. This may be necessary for editing messages.
     *
     * @param content: the String representing the new contents of the message.*/
    public void setContent(String content){
        this.content = content;
    }

    /**
     * Getter for author. Returns author's username String.
     * @return String: username of author.
     */
    public String getAuthor(){
        return this.author.getUsername();
    }

    /**
     * Getter for timestamp: returns when this Message was created.
     * @return LocalDateTime: time when this message was created.
     */
    public LocalDateTime getDateTime(){
        return this.timestamp;
    }

}
