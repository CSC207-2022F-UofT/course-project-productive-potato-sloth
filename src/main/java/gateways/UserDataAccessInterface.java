package gateways;

import entities.User;

public interface UserDataAccessInterface extends DataAccessInterface<User>{

    public boolean persistData();

    public void deleteAllUsers();

}
