package usecases.Login;

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
