package screens.CreateAccount.CreateAccount;

public class AccountCreationFailed extends RuntimeException{
    public AccountCreationFailed(String error) {
        super(error);
    }
}
