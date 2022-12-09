package screens.CreateAccount;

import gateways.UserDataAccessInterface;
import gateways.UserDatabaseGateway;
import useCases.CreateAccount.CreateAccountInputBoundary;
import useCases.CreateAccount.CreateAccountInteractor;
import useCases.CreateAccount.CreateAccountPresenter;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class CreateAccountMain {
    public static void main() throws IOException {
        JFrame application  =  new JFrame("Create Account");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

        UserDataAccessInterface gateway = new UserDatabaseGateway("database/UserFile1.ser");

        CreateAccountPresenter presenter = new CreateAccountResponseFormatter();

        CreateAccountInputBoundary createAccountInteractor = new CreateAccountInteractor(gateway, presenter);

        CreateAccountController createAccountController = new CreateAccountController(createAccountInteractor);

        CreateAccountScreen createAccountScreen = new CreateAccountScreen(createAccountController);

        screens.add(createAccountScreen, "hello");

        cardLayout.show(screens, "create account");
        application.pack();
        application.setVisible(true);


    }
}
