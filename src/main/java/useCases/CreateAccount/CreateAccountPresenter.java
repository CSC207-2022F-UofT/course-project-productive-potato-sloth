package useCases.CreateAccount;

public interface CreateAccountPresenter {
    CreateAccountResponseModel prepareSuccessView(CreateAccountResponseModel success);

    CreateAccountResponseModel prepareFailureView(String error);

}
