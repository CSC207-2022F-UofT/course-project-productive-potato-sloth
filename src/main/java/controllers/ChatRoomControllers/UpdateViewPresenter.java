package controllers.ChatRoomControllers;

import java.util.List;
import useCases.responseModels.MessageResponseModel;
import UI.MainUI;

public class UpdateViewPresenter implements UpdateViewPresenterInterface{
    MainUI UI;
    @Override
    public void setUI(MainUI UI){
        this.UI = UI;
        UI.setVisible(true);
    }
    @Override
    public MainUI getUI(){
        return this.UI;
    }
    @Override
    public List<MessageResponseModel> updateView(List<MessageResponseModel> response_models) {
        if(!(this.UI == null)){
            this.UI.setMessages(response_models);
        }
        return response_models;
    }
}
