package useCases.Login;

/**
 * An interface which hides the details of creating a viewModel for Login purposes
 */
public interface LoginPresenter {
    LoginResponseModel prepareSuccessView(LoginResponseModel success);
    LoginResponseModel prepareFailureView(String error);
}