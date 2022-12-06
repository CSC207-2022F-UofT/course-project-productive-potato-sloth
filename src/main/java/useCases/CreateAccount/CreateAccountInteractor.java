package useCases.CreateAccount;

import entities.User;
import gateways.UserDataAccessInterface;


public class CreateAccountInteractor implements CreateAccountInputBoundary {

    final UserDataAccessInterface gateway;
    final CreateAccountPresenter userPresenter;


    public CreateAccountInteractor(UserDataAccessInterface gateway, CreateAccountPresenter userPresenter) {
        this.gateway = gateway;
        this.userPresenter = userPresenter;
    }

    public CreateAccountResponseModel create(CreateAccountRequestModel requestModel) {

                if (requestModel.getUsername().isBlank()){
                    return userPresenter.prepareFailureView("Enter username.");
                }
                if (gateway.get(requestModel.getUsername()) != null){
                    return userPresenter.prepareFailureView("Username already exists.");
                }
                else if (requestModel.getPassword().isBlank()) {
                    return userPresenter.prepareFailureView("Enter password.");
                } else {
                        User user = new User(requestModel.getUsername(), requestModel.getPassword());
                        gateway.insert(user);
                        CreateAccountResponseModel createAccountResponse = new CreateAccountResponseModel(requestModel.getUsername(),
                                requestModel.getPassword());
                        return userPresenter.prepareSuccessView(createAccountResponse);
                }
      }
}
