package useCases.Login;

/**
 * An interface which hides the details of how a User is logged into the application
 */
public interface LoginInputBoundary {

    /**
     * The method which logs in a User
     *
     * @param requestModel Contains the information needed to log in a new User (the User's username and password)
     * @return The Response Model containing information about the now-logged-in User (the User's username and password)
     */
    LoginResponseModel create(LoginRequestModel requestModel);

}