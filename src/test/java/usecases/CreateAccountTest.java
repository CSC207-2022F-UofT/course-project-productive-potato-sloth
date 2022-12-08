package usecases;

import entities.User;
import gateways.UserDataAccessInterface;
import gateways.UserDatabaseGateway;
import org.junit.jupiter.api.Test;
import useCases.CreateAccount.CreateAccountInputBoundary;
import useCases.CreateAccount.CreateAccountPresenter;
import useCases.CreateAccount.CreateAccountRequestModel;
import useCases.CreateAccount.CreateAccountResponseModel;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateAccountTest {
    @Test
    public void check() throws IOException {
        User user = new User("group91", "softwaredesign");
        UserDataAccessInterface gateway = new UserDatabaseGateway("database/UserFile1.ser");
        List<User> userList = new ArrayList<User>();
        userList.add(user);

        CreateAccountPresenter presenter = new CreateAccountPresenter() {
            @Override
            public CreateAccountResponseModel prepareSuccessView(CreateAccountResponseModel success) {
                assertEquals(userList, gateway.getAll());
                assertEquals(new User("group91", "softwaredesign"), gateway.get("group91"));
                return null;
            }

            @Override
            public CreateAccountResponseModel prepareFailureView(String error) {
                fail("Use case failure is unexpected.");
                return null;
            }
        };

        CreateAccountInputBoundary interactor = new CreateAccountInputBoundary() {
            @Override
            public CreateAccountResponseModel create(CreateAccountRequestModel requestModel) {
                return null;
            }
        };

        CreateAccountRequestModel inputData = new CreateAccountRequestModel("group91", "softwaredesign");

        interactor.create(inputData);
    }

}
