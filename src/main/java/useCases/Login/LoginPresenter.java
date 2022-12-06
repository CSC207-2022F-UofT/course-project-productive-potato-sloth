package useCases.Login;

public interface LoginPresenter {
    LoginResponseModel prepareSuccessView(LoginResponseModel success);
    LoginResponseModel prepareFailureView(String error);
}
