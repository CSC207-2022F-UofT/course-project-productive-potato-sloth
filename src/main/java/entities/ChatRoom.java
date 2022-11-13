package entities;

import java.util.ArrayList;

public class ChatRoom {
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
    public void addMessage(Message message){
        this.messages.add(message);
    }

    public ArrayList<Message> getMessages(){
        return this.messages;
    }
}
