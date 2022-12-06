package screens.Login;

import screens.CreateAccount.AccountCreationFailed;
import useCases.Login.LoginPresenter;
import useCases.Login.LoginResponseModel;

public class LoginResponseFormatter implements LoginPresenter {

    @Override
    public LoginResponseModel prepareSuccessView(LoginResponseModel responseModel) {
        return responseModel;
    }

    @Override
    public LoginResponseModel prepareFailureView(String error) {
        throw new LoginFailed(error);    }
}
