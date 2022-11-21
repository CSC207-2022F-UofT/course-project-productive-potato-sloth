package useCases.CreateUser;

import src.main.java.entities.User;

public class CreateUserInteractor {

        public static User createUser(String username, String password) {
                CreateUserData createUser = new CreateUserData();
                return createUser.createUser(username, password);
        }
}
