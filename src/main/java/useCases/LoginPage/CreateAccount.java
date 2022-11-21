package useCases.LoginPage;

import entities.User;
import gateways.DataAccessInterface;
import useCases.CreateUser.CreateUserData;


public class CreateAccount{
    DataAccessInterface<User> gateway;
    public CreateAccount(DataAccessInterface<User> gateway)  {
        this.gateway = gateway;
    }

    public void createAccount(String username, String password) {
        User user = gateway.get(username);
        if (user == null) {
            gateway.insert(CreateUserData.createUser(username, password));
        }
        else {
            //display error message that username is in use so change username inputted
        }

    }
}
