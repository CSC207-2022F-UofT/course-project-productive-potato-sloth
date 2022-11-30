package entities;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.List;
import java.util.Collections;

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
        if(number > 0) {
            for (int i = index + 1; i <= number; i++) {
                if (len - i >= 0) {
                    return_list.add(this.messages.get(len-index - i));
                }
            }
        }
        else{
            for(int i = 0; i < -(number); i++){
                if(0 <= len - index + i && len - index + i < len){
                    return_list.add(this.messages.get(len-index+i));
                }
            }
            Collections.reverse(return_list);
        }
        return return_list;
    }
}
