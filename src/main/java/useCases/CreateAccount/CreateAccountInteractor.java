package useCases.CreateAccount;

import entities.User;
import gateways.UserDatabaseGateway;


public abstract class CreateAccountInteractor implements CreateAccountInputBoundary {

    final UserDatabaseGateway gateway;
    final CreateAccountPresenter userPresenter;



    public CreateAccountInteractor(UserDatabaseGateway gateway, CreateAccountPresenter userPresenter) {
        this.gateway = gateway;
        this.userPresenter = userPresenter;
    }

    public CreateAccountResponseModel create(CreateAccountRequestModel requestModel) {

                if (gateway.get(requestModel.getUsername()) != null) {
                        return userPresenter.prepareFailureView("Username already exists.");
                } else {
                        User user = new User(requestModel.getUsername(), requestModel.getPassword());
                        gateway.insert(user);
                        CreateAccountResponseModel createAccountResponse = new CreateAccountResponseModel(requestModel.getUsername(),
                                requestModel.getPassword());
                        return userPresenter.prepareSuccessView(createAccountResponse);
                }
      }
}
