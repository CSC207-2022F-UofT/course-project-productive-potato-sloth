package screens.CreateAccount;

import useCases.CreateAccount.CreateAccountInputBoundary;
import useCases.CreateAccount.CreateAccountRequestModel;
import useCases.CreateAccount.CreateAccountResponseModel;

public class CreateAccountController {
    final CreateAccountInputBoundary accountCreater;

    public CreateAccountController(CreateAccountInputBoundary accountCreater) {
        this.accountCreater = accountCreater;
    }

    CreateAccountResponseModel create(String username, String password) {
        CreateAccountRequestModel requestModel = new CreateAccountRequestModel(username, password);

        return accountCreater.create(requestModel);
    }

}
