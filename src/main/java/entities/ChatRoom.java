package entities;

import java.util.ArrayList;

public class ChatRoom {
    ArrayList<Message> messages;

    public ChatRoom(){
        this.messages = new ArrayList<>();
    }

    public void AddMessage(Message message){
        this.messages.add(message);
    }

    public ArrayList<Message> GetMessages(){
        return this.messages;
    }
}
