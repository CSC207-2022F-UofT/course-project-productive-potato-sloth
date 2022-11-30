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
    public List<MessageResponseModel> updateView(List<MessageResponseModel> responsemodels) {
        return responsemodels;
    }
}
