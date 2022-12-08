package screens.CreateAccount;

import useCases.CreateAccount.CreateAccountPresenter;
import useCases.CreateAccount.CreateAccountResponseModel;

public class CreateAccountResponseFormatter implements CreateAccountPresenter {
    @Override
    public CreateAccountResponseModel prepareSuccessView(CreateAccountResponseModel response) {
        return response;
    }

    public CreateAccountResponseModel prepareFailureView(String error) {
        throw new AccountCreationFailed(error);
    }
}
