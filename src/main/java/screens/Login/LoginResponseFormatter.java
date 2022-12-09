package screens.Login;

import useCases.Login.LoginPresenter;
import useCases.Login.LoginResponseModel;

/**
 * A presenter which formats the Login response into a view model
 */
public class LoginResponseFormatter implements LoginPresenter {

    /**
     * Prepares a successful view model for Login
     *
     * @param responseModel The response from the output boundary
     * @return The view model
     */
    @Override
    public LoginResponseModel prepareSuccessView(LoginResponseModel responseModel) {
        return responseModel;
    }

    /**
     * Prepares a failure view model for Login
     *
     * @param error The details of the error
     * @return The view model
     */
    @Override
    public LoginResponseModel prepareFailureView(String error) {
        throw new LoginFailed(error);    }
}
