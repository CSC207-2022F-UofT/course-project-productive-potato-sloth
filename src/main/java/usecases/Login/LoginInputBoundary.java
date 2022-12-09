package usecases.Login;

import usecases.CreateAccount.CreateAccountRequestModel;

public interface LoginInputBoundary {
    LoginResponseModel create(CreateAccountRequestModel requestModel);

}
