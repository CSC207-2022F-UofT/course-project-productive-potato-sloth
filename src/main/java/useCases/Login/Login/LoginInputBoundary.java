package useCases.Login.Login;

import useCases.CreateAccount.CreateAccountRequestModel;

public interface LoginInputBoundary {
    LoginResponseModel create(CreateAccountRequestModel requestModel);

}
