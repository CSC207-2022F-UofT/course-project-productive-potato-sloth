package useCases.CreateAccount;

/**
 * A class which is returned from CreateAccount-relevant use cases as a Response
 */
public class CreateAccountResponseModel {
    private String username;
    private String password;

    public CreateAccountResponseModel(String username, String password) {
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
