package useCases.LoginPage;

import gateways.UserDatabaseGateway;
import services.CurrentUserService;

public abstract class LoginInteractor implements LoginInputBoundary {
    final UserDatabaseGateway gateway;
    final LoginPresenter loginPresenter;
    final CurrentUserService userService;



    public LoginInteractor(UserDatabaseGateway gateway, LoginPresenter loginPresenter, CurrentUserService userService) {
        this.gateway = gateway;
        this.loginPresenter = loginPresenter;
        this.userService = userService;
    }

    public LoginResponseModel create(LoginRequestModel requestModel) {

        if (gateway.get(requestModel.getUsername()) != null) {
            return loginPresenter.prepareFailureView("User does not exist. Please create an account.");
        }
        else if (requestModel.getPassword() == (gateway.get(requestModel.getUsername()).getPassword())){
            userService.setCurrentUser(gateway.get(requestModel.getUsername()));
            return loginPresenter.prepareSuccessView("User " + requestModel.getUsername() + " logged in.");
        }
        else {
            return loginPresenter.prepareFailureView("Password is incorrect.");
        }
    }
}
