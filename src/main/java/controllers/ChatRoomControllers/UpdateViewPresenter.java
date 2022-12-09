package controllers.ChatRoomControllers;

import java.util.List;
import usecases.responseModels.MessageResponseModel;
import UI.MainUI;

/**
 * This is a class that calls UI methods to update the view.
 */
public class UpdateViewPresenter implements UpdateViewPresenterInterface{
    MainUI UI;

    /**
     * Getter and setter for the UI.
     * @param UI: the reference to the UI object.
     */
    @Override
    public void setUI(MainUI UI){
        this.UI = UI;
    }
    @Override
    public MainUI getUI(){
        return this.UI;
    }

    /**
     * Takes in a list of ResponseModels (size = 3) and calls update view method in UI with it.
     * If the UI is null this method fails quietly. This is done for testing purposes to isolate UI issues from
     * presenter issues (i.e. presenter can be tested without initializing a UI object).
     * @param response_models: list of MessageResponseModels.
     * @return same list of ResponseModels. This is mostly done for testing purposes.
     */
    @Override
    public List<MessageResponseModel> updateView(List<MessageResponseModel> response_models) {
        if(!(this.UI == null)){
            this.UI.setMessages(response_models);
        }
        return response_models;
    }
}
