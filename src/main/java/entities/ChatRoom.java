package entities;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.List;

public class ChatRoom implements Serializable{
    List<Message> messages;

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

    public List<Message> GetMessages(){
        return this.messages;
    }

    public List<Message> GetMessages(int number, int index){
        List<Message> return_list= new ArrayList<Message>();
        int len = this.messages.size();
        for(int i = index + 1; i <= number; i++){
            if(len - i >= 0) {
                return_list.add(this.messages.get(len - i));
            }
        }
        return return_list;
    }
}
