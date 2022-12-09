package test.java.usecases;

import entities.User;
import gateways.UserDataAccessInterface;
import gateways.UserDatabaseGateway;
import org.junit.jupiter.api.Test;
import useCases.CreateAccount.CreateAccountInputBoundary;
import useCases.CreateAccount.CreateAccountPresenter;
import useCases.CreateAccount.CreateAccountRequestModel;
import useCases.CreateAccount.CreateAccountResponseModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CreateAccountTest {
    @Test
    public void check() throws IOException {
        User user = new User("group91", "softwaredesign");
        UserDataAccessInterface gateway = new UserDatabaseGateway("database/UserFile1.ser");
        List<User> userList = new ArrayList<User>();
        userList.add(user);

        // This creates an anonymous implementing class for the Output Boundary.
        CreateAccountPresenter presenter = new CreateAccountPresenter() {
            @Override
            public CreateAccountResponseModel prepareSuccessView(CreateAccountResponseModel success) {
                //Check that the Output Data and associated changes are correct
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

        // Input data: we can make this up for the test. Normally it would be created by the Controller.
        CreateAccountRequestModel inputData = new CreateAccountRequestModel("group91", "softwaredesign");

        // Run the use case
        interactor.create(inputData);
    }

}
