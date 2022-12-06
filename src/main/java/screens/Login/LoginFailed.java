package screens.Login;

public class LoginFailed extends RuntimeException{
    public LoginFailed(String error) {
        super(error);
    }
}
