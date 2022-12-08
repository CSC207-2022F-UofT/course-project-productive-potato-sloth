package useCases.Login;

/**
 * A class which is returned from Login-relevant use cases as a Response
 */
public class LoginResponseModel {
    private String username;
    private String password;

    public LoginResponseModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
