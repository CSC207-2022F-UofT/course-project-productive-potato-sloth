package entities;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.List;
import java.util.Collections;

public class ChatRoom implements Serializable{
    List<Message> messages;

    /**
     * A ChatRoom is an entity that contains a List of Message entities. It can add Messages to the List and get
     * Messages from it.
     */
    public ChatRoom(){
        this.messages = new ArrayList<>();
    }

    @Override
    public String toString(){
        return "chatRoom with messages " + this.messages.toString();
    }

    /**Adds message to List of Messages.
     *
     * @param message: Message to be added.
     */
    public void AddMessage(Message message){
        this.messages.add(message);
    }

    public List<Message> GetMessages(){
        return this.messages;
    }

    /**
     * Returns a List of Messages from old to new (i.e. oldest messages first).
     *
     * @param number: how many Messages to retrieve.
     * @param index: where to start the retrieval process. Index 0 means starting from the last
     *             (most recently added) message.
     * @return a List of Messages.
     */
    public List<Message> GetMessages(int number, int index){
        List<Message> return_list= new ArrayList<Message>();
        int len = this.messages.size();
        if(number > 0) {
            for (int i = 1; i <= number; i++) {
                if (len - index - i >= 0) {
                    return_list.add(this.messages.get(len-index - i));
                }
            }
            Collections.reverse(return_list);
        }
        else{
            for(int i = 0; i < -(number); i++){
                if(0 <= len - index + i && len - index + i < len){
                    return_list.add(this.messages.get(len-index+i));
                }
            }
        }
        return return_list;
    }
}
