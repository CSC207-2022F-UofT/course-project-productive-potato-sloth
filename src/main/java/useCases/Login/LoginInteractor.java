package useCases.Login;

import gateways.UserDataAccessInterface;
import services.CurrentUserService;

import java.util.Objects;

/**
 * A use case which logs in a User
 */
public abstract class LoginInteractor implements LoginInputBoundary {
    /**
     * The interface which allows access to the UserDatabase
     */
    final UserDataAccessInterface gateway;
    /**
     * The interface which directs the relevant data for creating a new User
     */
    final LoginPresenter loginPresenter;
    /**
     * The class which stores the current User (and relevant information) logged into the application
     */
    final CurrentUserService userService;

    /**
     * Creates an instance of LoginInteractor with the required fields
     *
     * @param gateway Interface for accessing the UserDatabase
     * @param loginPresenter Interface for directing the relevant data for creating a new User
     * @param userService Class for storing the current User (and relevant information) logged into the application
     */
    public LoginInteractor(UserDataAccessInterface gateway, LoginPresenter loginPresenter, CurrentUserService userService) {
        this.gateway = gateway;
        this.loginPresenter = loginPresenter;
        this.userService = userService;
    }

    /**
     * Logs in a User with the fields specified in the Request Model
     *
     * @param requestModel The input data with all required fields relevant to creating a User
     * @return The Response Model with all the User fields of the logged-in User
     */
    public LoginResponseModel create(LoginRequestModel requestModel) {

        if (gateway.get(requestModel.getUsername()) == null) {
            return loginPresenter.prepareFailureView("User does not exist. Please create an account.");
        }
        else if (Objects.equals(requestModel.getPassword(), gateway.get(requestModel.getUsername()).getPassword())){
            userService.setCurrentUser(gateway.get(requestModel.getUsername()));
            LoginResponseModel loginResponse = new LoginResponseModel(requestModel.getUsername(),
                    requestModel.getPassword());
            return loginPresenter.prepareSuccessView(loginResponse);
        }
        else {
            return loginPresenter.prepareFailureView("Password is incorrect.");
        }
    }
}
