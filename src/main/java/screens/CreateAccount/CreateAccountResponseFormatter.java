package screens.CreateAccount;

import useCases.CreateAccount.CreateAccountPresenter;
import useCases.CreateAccount.CreateAccountResponseModel;

/**
 * A presenter which formats the CreateAccount response into a view model
 */
public class CreateAccountResponseFormatter implements CreateAccountPresenter {

    /**
     * Prepares a successful view model for CreateAccount
     *
     * @param response The response from the output boundary
     * @return The view model
     */
    @Override
    public CreateAccountResponseModel prepareSuccessView(CreateAccountResponseModel response) {
        return response;
    }

    /**
     * Prepares a failure view model for CreateAccount
     *
     * @param error The details of the error
     * @return The view model
     */
    public CreateAccountResponseModel prepareFailureView(String error) {
        throw new AccountCreationFailed(error);
    }
}
