package entities;

import java.io.Serializable;
import java.util.ArrayList;

public class ChatRoom implements Serializable {
    ArrayList<Message> messages;

    public ChatRoom(){
        this.messages = new ArrayList<>();
    }

    @Override
    public String toString(){
        return "chatRoom with messages " + this.messages.toString();
    }

    /**Adds message to ArrayList of Messages.
     *
     * @param message: Message to be added.
     */
    public void AddMessage(Message message){
        this.messages.add(message);
    }

    public ArrayList<Message> GetMessages(){
        return this.messages;
    }
}
