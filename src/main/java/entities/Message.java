package entities;
import java.time.LocalDateTime;
public class Message {
    String content;
    //User author;
    LocalDateTime timestamp;

    public Message(String content/*, *User user*/){
        this.content = content;
        /*this.author = user;*/
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

    public String getAuthor(){
        //return this.author;
        return "";
    }

    public LocalDateTime getDateTime(){
        return this.timestamp;
    }

}
