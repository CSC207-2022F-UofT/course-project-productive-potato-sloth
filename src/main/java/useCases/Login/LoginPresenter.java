package useCases.Login;

public interface LoginPresenter {
    LoginResponseModel prepareSuccessView(String success);
    LoginResponseModel prepareFailureView(String error);
}
