package useCases.responseModels;
import entities.Message;

public class MessageResponseModel {
    //Read-only response model containing ready-to-print (on screen) String forms of
    //the instance variables of Message.
    String content;
    String author;
    String timeStamp;
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
