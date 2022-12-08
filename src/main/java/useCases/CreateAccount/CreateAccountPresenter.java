package useCases.CreateAccount;

/**
 * An interface which hides the details of creating a viewModel for CreateAccount purposes
 */
public interface CreateAccountPresenter {
    CreateAccountResponseModel prepareSuccessView(CreateAccountResponseModel success);

    CreateAccountResponseModel prepareFailureView(String error);

}
