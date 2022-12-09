package useCases.CreateAccount;

/**
 * An interface which hides the details of how a new User is created
 */
public interface CreateAccountInputBoundary {

    /**
     * The method which creates a new User
     *
     * @param requestModel Contains the information needed to create a new User (the User's username and password)
     * @return The Response Model containing information about the new User created (the User's username and password)
     */
    CreateAccountResponseModel create(CreateAccountRequestModel requestModel);
}