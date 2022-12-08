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
//        service.setCurrentUser(user);
        List<User> userList = new ArrayList<User>();
        userList.add(user);

        LoginPresenter presenter = new LoginPresenter() {
            @Override
            public LoginResponseModel prepareSuccessView(LoginResponseModel success) {
                return null;
            }

            @Override
            public LoginResponseModel prepareFailureView(String error) {
                fail("Use case failure is unexpected.");
                assertEquals(userList, gateway.getAll());
                assertEquals(new User("group91", "softwaredesign"), gateway.get("group91"));
                assertEquals(service.getCurrentUser(), user);
                return null;
            }
        };
        LoginInputBoundary interactor = new LoginInputBoundary() {
            @Override
            public LoginResponseModel create(LoginRequestModel requestModel) {
                return null;
            }
        };

        LoginRequestModel inputData = new LoginRequestModel("group91", "softwaredesign");

        interactor.create(inputData);
    }

}
