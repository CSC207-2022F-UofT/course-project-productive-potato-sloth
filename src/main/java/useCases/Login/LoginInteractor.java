package useCases.Login;

import gateways.UserDataAccessInterface;
import gateways.UserDatabaseGateway;
import services.CurrentUserService;
import useCases.CreateAccount.CreateAccountResponseModel;

import java.util.Objects;

public abstract class LoginInteractor implements LoginInputBoundary {
    final UserDataAccessInterface gateway;
    final LoginPresenter loginPresenter;
    final CurrentUserService userService;



    public LoginInteractor(UserDataAccessInterface gateway, LoginPresenter loginPresenter, CurrentUserService userService) {
        this.gateway = gateway;
        this.loginPresenter = loginPresenter;
        this.userService = userService;
    }

    public LoginResponseModel create(LoginRequestModel requestModel) {

        if (gateway.get(requestModel.getUsername()) == null) {
            return loginPresenter.prepareFailureView("User does not exist. Please create an account.");
        }
        else if (Objects.equals(requestModel.getPassword(), gateway.get(requestModel.getUsername()).getPassword())){
            userService.setCurrentUser(gateway.get(requestModel.getUsername()));
            LoginResponseModel loginResponse = new LoginResponseModel(requestModel.getUsername(),
                    requestModel.getPassword());
            return loginPresenter.prepareSuccessView(loginResponse);
        }
        else {
            return loginPresenter.prepareFailureView("Password is incorrect.");
        }
    }
}
