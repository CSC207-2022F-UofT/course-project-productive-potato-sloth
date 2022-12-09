package screens.Login;

/**
 * An Exception which represents a Login-related error
 */
public class LoginFailed extends RuntimeException{
    /**
     * Instantiates a LoginFailed (error) with a detailed message
     *
     * @param error The error message
     */
    public LoginFailed(String error) {
        super(error);
    }
}
