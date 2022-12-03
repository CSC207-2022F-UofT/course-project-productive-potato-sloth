package useCases.CreateAccount.CreateAccount;

public interface CreateAccountPresenter {
    CreateAccountResponseModel prepareSuccessView(CreateAccountResponseModel success);

    CreateAccountResponseModel prepareFailureView(String error);

}
