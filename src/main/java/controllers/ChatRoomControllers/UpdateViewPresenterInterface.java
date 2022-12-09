package controllers.ChatRoomControllers;

import java.util.List;

import UI.MainUI;
import usecases.responseModels.MessageResponseModel;

public interface UpdateViewPresenterInterface {
    public List<MessageResponseModel> updateView(List<MessageResponseModel> models);
    public void setUI(MainUI UI);
    public MainUI getUI();
}
