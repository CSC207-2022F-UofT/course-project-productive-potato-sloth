package entities;

import java.util.ArrayList;

public class ChatRoom {
    ArrayList<Message> messages;

    public ChatRoom(){
        this.messages = new ArrayList<>();
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
