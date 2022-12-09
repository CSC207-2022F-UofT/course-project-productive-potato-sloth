package usecases.responseModels;
import entities.Message;

public class MessageResponseModel {
    //Read-only response model containing ready-to-print (on screen) String forms of
    //the instance variables of Message.
    String content;
    String author;
    String timeStamp;

    /**
     * This is the constructor of the MessageResponseModel. Note that the timestamp
     * is a String instead of LocalDateTime, since we want to pass this into the presenter and UI and Strings are easier
     * for the UI to render.
     * @param message: Message object containing our data.
     */
    public MessageResponseModel(Message message){
        this.content = message.toString();
        this.author = message.getAuthor();
        String minutes = String.valueOf(message.getDateTime().getMinute());
        if(minutes.length() < 2){
            minutes = "0" + minutes;
        }
        this.timeStamp = Integer.toString(message.getDateTime().getHour()) +
                ":" + minutes;
    }

    /**
     * Getter and setter methods for instance variables.
     */
    public String getAuthor(){
        return this.author;
    }
    public String getContent(){
        return this.content;
    }
    public String getTimeStamp(){
        return this.timeStamp;
    }
}
