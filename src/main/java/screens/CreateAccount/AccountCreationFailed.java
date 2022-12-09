package screens.CreateAccount;

/**
 * An Exception which represents a CreateAccount-related error
 */
public class AccountCreationFailed extends RuntimeException{
    /**
     * Instantiates a AccountCreationFailed (error) with a detailed message
     *
     * @param error The error message
     */
    public AccountCreationFailed(String error) {
        super(error);
    }
}
