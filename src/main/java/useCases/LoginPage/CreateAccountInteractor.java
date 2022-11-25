package useCases.LoginPage;

import gateways.UserDatabaseGateway;
import useCases.CreateUser.CreateUserData;
import useCases.LoginPage.CreateAccountInputBoundary;
import useCases.LoginPage.CreateAccountPresenter;
import useCases.LoginPage.CreateAccountRequestModel;
import useCases.LoginPage.CreateAccountResponseModel;

public abstract class CreateAccountInteractor implements CreateAccountInputBoundary {

    final UserDatabaseGateway gateway;
    final CreateAccountPresenter userPresenter;



    public CreateAccountInteractor(UserDatabaseGateway gateway, CreateAccountPresenter userPresenter) {
        this.gateway = gateway;
        this.userPresenter = userPresenter;
    }

    public CreateAccountResponseModel create(CreateAccountRequestModel requestModel, String username, String password) {

                if (gateway.get(username) != null) {
                        return userPresenter.prepareFailureView("Username already exists.");
                } else {
                        gateway.insert(CreateUserData.createUser(username, password));
                        return userPresenter.prepareSuccessView("User is successfully created.");
                }
      }
}
