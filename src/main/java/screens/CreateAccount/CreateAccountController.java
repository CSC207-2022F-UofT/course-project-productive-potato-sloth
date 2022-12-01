package screens.CreateAccount;

import useCases.CreateAccount.CreateAccountInputBoundary;
import useCases.CreateAccount.CreateAccountRequestModel;
import useCases.CreateAccount.CreateAccountResponseModel;

public class CreateAccountController {
    final CreateAccountInputBoundary userInput;

    public CreateAccountController(CreateAccountInputBoundary accountCreater) {
        this.userInput = accountCreater;
    }

    CreateAccountResponseModel create(String username, String password) {
        CreateAccountRequestModel requestModel = new CreateAccountRequestModel(username, password);

        return userInput.create(requestModel);
    }

}
