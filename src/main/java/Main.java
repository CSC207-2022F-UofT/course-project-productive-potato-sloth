

import gateways.UserDatabaseGateway;
import useCases.CreateAccount.CreateAccountPresenter;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        // Build the main program window
        JFrame application = new JFrame("Login Example");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

        // Create the parts to plug into the Use Case+Entities engine
        UserDatabaseGateway user;
//        try {
//            user = new FileUser("./users.csv");
//        } catch (IOException e) {
//            throw new RuntimeException("Could not create file.");
//        }
//        CreateAccountPresenter presenter = new CreateAccountResponseFormatter();
//        CreateAccountInputBoundary interactor = new CreateAccountInteractor(user, presenter, userFactory);
//        CreateAccountController accountController = new CreateAccountController(interactor);
//
//        // Build the GUI, plugging in the parts
//        CreateAccountScreen registerScreen = new CreateAccountScreen(accountController);
//        screens.add(registerScreen, "Welcome");
//        cardLayout.show(screens, "Create Account");
//        application.pack();
//        application.setVisible(true);


    }

}