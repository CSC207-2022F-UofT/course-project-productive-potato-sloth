package usecases;

import entities.*;

public class ChatRoomInteractor {
    ChatRoom room;
    public ChatRoomInteractor(ChatRoom room) {
        this.room = room;
        //Is this right? Please check. Because we have to figure out if the program is initialized from
        //the "bottom" layers (i.e. lower layers get called first) or "top" layers, and in the latter case
        //this approach won't be correct.
    }
    public void sendMessage(String message/*, User user*/){
        Message temp_message = new Message(message/*, user*/);
        this.room.AddMessage(temp_message);
        /*ChatRoomPresenterInterface.updateView();
        * --this line both saves to a .txt file and updates the view according to the file. Itmay be split into 2
        * separate methods later.*/
    }
}
