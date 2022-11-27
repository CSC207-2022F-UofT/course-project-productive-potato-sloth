package controllers;

import java.util.List;

public class UpdateViewPresenter implements UpdateViewPresenterInterface{

    @Override
    public void updateView(List messages, List usernames, List timestamps) {
        for(int i = 0; i < messages.size(); i++){
            //make a new text box in the chat room's View with the Message's content, timestamp and username on it
        }
    }
}
