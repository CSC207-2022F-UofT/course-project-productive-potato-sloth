package usecases;

import gateways.UserDataAccessInterface;
import gateways.UserDatabaseGateway;
import org.junit.Test;
import services.CurrentUserService;

import java.io.IOException;

public class CreateAccountTest {

    @Test
    public void check() throws IOException {
        UserDataAccessInterface gateway = new UserDatabaseGateway("database/UserFile1.ser");
        CurrentUserService service = new CurrentUserService();

        System.out.println(gateway.getAll().get(0).getPassword());
    }

}
