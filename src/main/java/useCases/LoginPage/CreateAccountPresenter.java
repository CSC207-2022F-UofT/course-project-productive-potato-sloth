package useCases.LoginPage;

public interface CreateAccountPresenter {
    CreateAccountResponseModel prepareSuccessView(CreateAccountRequestModel user);

    CreateAccountResponseModel prepareFailureView(String error);

}
