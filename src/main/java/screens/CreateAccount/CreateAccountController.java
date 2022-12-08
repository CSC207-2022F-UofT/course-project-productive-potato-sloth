package screens.CreateAccount;

import useCases.CreateAccount.CreateAccountInputBoundary;
import useCases.CreateAccount.CreateAccountRequestModel;
import useCases.CreateAccount.CreateAccountResponseModel;

/**
 * A controller which takes user input relevant to creating a new account (new User) and sends it through the input boundary
 */
public class CreateAccountController {

    /**
     * The interface which allows access to the CreateAccountInteractor use case
     */
    final CreateAccountInputBoundary accountCreater;

    /**
     * Creates an instance of CreateAccountInteractor with the required fields
     *
     * @param accountCreater Interface for accessing the CreateAccountInteractor use case
     */
    public CreateAccountController(CreateAccountInputBoundary accountCreater) {
        this.accountCreater = accountCreater;
    }

    CreateAccountResponseModel create(String username, String password) {
        CreateAccountRequestModel requestModel = new CreateAccountRequestModel(username, password);

        return accountCreater.create(requestModel);
    }

}
