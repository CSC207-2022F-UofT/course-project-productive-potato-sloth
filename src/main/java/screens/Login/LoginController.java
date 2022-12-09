package screens.Login;

import useCases.Login.LoginInputBoundary;
import useCases.Login.LoginRequestModel;
import useCases.Login.LoginResponseModel;

/**
 * A controller which takes user input relevant to logging in a User and sends it through the input boundary
 */
public class LoginController {

    /**
     * The interface which allows access to the LoginInteractor use case
     */
    final LoginInputBoundary loginInteractor;

    /**
     * Creates an instance of LoginController with the required fields
     *
     * @param loginInteractor Interface for accessing the LoginInteractor use case
     */
    public LoginController(LoginInputBoundary loginInteractor) {
        this.loginInteractor = loginInteractor;
    }

    LoginResponseModel create(String username, String password) {
        LoginRequestModel requestModel = new LoginRequestModel(username, password);

        return loginInteractor.create(requestModel);
    }
}
