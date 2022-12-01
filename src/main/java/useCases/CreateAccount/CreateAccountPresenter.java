package useCases.CreateAccount;

public interface CreateAccountPresenter {
    CreateAccountResponseModel prepareSuccessView(String success);

    CreateAccountResponseModel prepareFailureView(String error);

}
