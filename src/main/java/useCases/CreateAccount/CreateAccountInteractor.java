package useCases.CreateAccount;

import entities.User;
import gateways.UserDataAccessInterface;

/**
 * A use case which creates a new User
 */
public class CreateAccountInteractor implements CreateAccountInputBoundary {

    /**
     * The interface which allows access to the UserDatabase
     */
    final UserDataAccessInterface gateway;
    /**
     * The interface which directs the relevant data for creating a new User
     */
    final CreateAccountPresenter userPresenter;

    /**
     * Creates an instance of CreateAccountInteractor with the required fields
     *
     * @param gateway Interface for accessing the UserDatabase
     * @param userPresenter Interface for directing the relevant data for creating a new User
     */
    public CreateAccountInteractor(UserDataAccessInterface gateway, CreateAccountPresenter userPresenter) {
        this.gateway = gateway;
        this.userPresenter = userPresenter;
    }

    /**
     * Creates a User with the fields specified in the Request Model
     *
     * @param requestModel The input data with all required fields relevant to creating a User
     * @return The Response Model with all the User fields of the new User
     */
    public CreateAccountResponseModel create(CreateAccountRequestModel requestModel) {

                if (requestModel.getUsername().isBlank()){
                    return userPresenter.prepareFailureView("Enter username.");
                }
                if (gateway.get(requestModel.getUsername()) != null){
                    return userPresenter.prepareFailureView("Username already exists.");
                }
                else if (requestModel.getPassword().isBlank()) {
                    return userPresenter.prepareFailureView("Enter password.");
                } else {
                        User user = new User(requestModel.getUsername(), requestModel.getPassword());
                        gateway.insert(user);
                        CreateAccountResponseModel createAccountResponse = new CreateAccountResponseModel(requestModel.getUsername(),
                                requestModel.getPassword());
                        return userPresenter.prepareSuccessView(createAccountResponse);
                }
      }
}
