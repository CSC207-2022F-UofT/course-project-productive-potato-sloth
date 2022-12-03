package useCases.Login.Login;

public interface LoginPresenter {
    LoginResponseModel prepareSuccessView(String success);
    LoginResponseModel prepareFailureView(String error);
}
