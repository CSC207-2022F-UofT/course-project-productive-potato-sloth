package useCases.CreateAccount;

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
