package usecases.CreateAccount;

public interface CreateAccountPresenter {
    CreateAccountResponseModel prepareSuccessView(CreateAccountResponseModel success);

    CreateAccountResponseModel prepareFailureView(String error);

}
