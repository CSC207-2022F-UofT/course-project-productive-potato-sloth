package useCases.LoginPage;

public interface CreateAccountPresenter {
    CreateAccountResponseModel prepareSuccessView(String success);

    CreateAccountResponseModel prepareFailureView(String error);

}
