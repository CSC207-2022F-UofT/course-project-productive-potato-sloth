package controllers;

import java.util.List;
import useCases.responseModels.MessageResponseModel;

public interface UpdateViewPresenterInterface {
    public List<MessageResponseModel> updateView(List<MessageResponseModel> models);
}
