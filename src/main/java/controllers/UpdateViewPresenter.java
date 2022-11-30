package controllers;

import java.util.List;
import useCases.responseModels.MessageResponseModel;
import UI.MainUI;

public class UpdateViewPresenter implements UpdateViewPresenterInterface{
    MainUI UI;
    public void setUI(MainUI UI){
        this.UI = UI;
    }
    @Override
    public void updateView(List<MessageResponseModel> response_models) {
        if(!(this.UI.equals(null))){
            this.UI.setMessages(response_models);
        }
    }
}
