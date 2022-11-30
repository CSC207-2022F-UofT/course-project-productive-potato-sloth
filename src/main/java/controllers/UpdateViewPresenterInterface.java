package controllers;

import java.util.List;
import useCases.responseModels.MessageResponseModel;

public interface UpdateViewPresenterInterface {
    public void updateView(List<MessageResponseModel> models);
}
