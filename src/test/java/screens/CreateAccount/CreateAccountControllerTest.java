package screens.CreateAccount;

import useCases.CreateAccount.CreateAccountInputBoundary;
import useCases.CreateAccount.CreateAccountRequestModel;
import useCases.CreateAccount.CreateAccountResponseModel;

class CreateAccountControllerTest {
    CreateAccountResponseModel accountResponseModel = new CreateAccountResponseModel("chhavi", "csc207");
    CreateAccountRequestModel accountRequestModel = new CreateAccountRequestModel("chhavi", "csc207");
    CreateAccountInputBoundary accountCreater = new CreateAccountInputBoundary() {
        @Override
        public CreateAccountResponseModel create(CreateAccountRequestModel requestModel) {
            return accountResponseModel;
        }
    };
    CreateAccountController account = new CreateAccountController(accountCreater);


}
