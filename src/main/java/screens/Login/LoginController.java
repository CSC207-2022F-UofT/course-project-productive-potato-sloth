package screens.Login;

import useCases.Login.LoginInputBoundary;
import useCases.Login.LoginRequestModel;
import useCases.Login.LoginResponseModel;

public class LoginController {
    final LoginInputBoundary loginInteractor;
    public LoginController(LoginInputBoundary loginInteractor) {
        this.loginInteractor = loginInteractor;
    }

    LoginResponseModel create(String username, String password) {
        LoginRequestModel requestModel = new LoginRequestModel(username, password);

        return loginInteractor.create(requestModel);
    }
}
