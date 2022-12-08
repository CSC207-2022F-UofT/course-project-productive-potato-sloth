package useCases.CreateAccount;

/**
 * A class which is passed into CreateAccount-relevant use cases as a Request
 */
public class CreateAccountRequestModel {

    private String username;
    private String password;

    public CreateAccountRequestModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
