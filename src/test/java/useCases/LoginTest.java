package usecases;

import entities.User;
import gateways.UserDataAccessInterface;
import gateways.UserDatabaseGateway;
import org.junit.jupiter.api.Test;
import services.CurrentUserService;
import useCases.Login.LoginInputBoundary;
import useCases.Login.LoginPresenter;
import useCases.Login.LoginRequestModel;
import useCases.Login.LoginResponseModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class LoginTest {

    @Test
    public void check() throws IOException {
        User user = new User("group91", "softwaredesign");
        UserDataAccessInterface gateway = new UserDatabaseGateway("database/UserFile1.ser");
        CurrentUserService service = new CurrentUserService();
        List<User> userList = new ArrayList<User>();
        userList.add(user);

        // This creates an anonymous implementing class for the Output Boundary.
        LoginPresenter presenter = new LoginPresenter() {
            @Override
            public LoginResponseModel prepareSuccessView(LoginResponseModel success) {
                //Check that the Output Data and associated changes are correct
                assertEquals(userList, gateway.getAll());
                assertEquals(new User("group91", "softwaredesign"), gateway.get("group91"));
                assertEquals(service.getCurrentUser(), user);
                return null;
            }

            @Override
            public LoginResponseModel prepareFailureView(String error) {
                fail("Use case failure is unexpected.");
                return null;
            }
        };
        LoginInputBoundary interactor = new LoginInputBoundary() {
            @Override
            public LoginResponseModel create(LoginRequestModel requestModel) {
                return null;
            }
        };

        // Input data: we can make this up for the test. Normally it would be created by the Controller.
        LoginRequestModel inputData = new LoginRequestModel("group91", "softwaredesign");

        // Run the use case
        interactor.create(inputData);
    }

}
