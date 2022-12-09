package useCases.Login;

import useCases.CreateAccount.CreateAccountRequestModel;

public interface LoginInputBoundary {
    LoginResponseModel create(CreateAccountRequestModel requestModel);

}