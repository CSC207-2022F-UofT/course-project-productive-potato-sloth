package useCases.CreateUser;

import entities.User;

public class CreateUserData {
   public static User createUser(String username, String password) {
      return new User(username, password);
   }
}
