package controllers;

import java.util.List;
import useCases.responseModels.MessageResponseModel;

public class UpdateViewPresenter implements UpdateViewPresenterInterface{

    @Override
    public List<MessageResponseModel> updateView(List<MessageResponseModel> responsemodels) {
        return responsemodels;
    }
}
