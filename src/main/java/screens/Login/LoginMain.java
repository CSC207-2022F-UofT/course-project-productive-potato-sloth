package screens.Login;

import gateways.UserDataAccessInterface;
import gateways.UserDatabaseGateway;
import services.CurrentUserService;
import useCases.Login.LoginInputBoundary;
import useCases.Login.LoginInteractor;
import useCases.Login.LoginPresenter;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class LoginMain {
    public static void main(String[] args) throws IOException {
        JFrame application  =  new JFrame("Log In");
        LoginScreen.application = application;
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

        UserDataAccessInterface gateway = new UserDatabaseGateway("database/UserFile1.ser");
        CurrentUserService service = new CurrentUserService();

        //       System.out.println(gateway.getAll().get(0).getPassword());

        LoginPresenter presenter = new LoginResponseFormatter();

        LoginInputBoundary loginInteractor = new LoginInteractor(gateway, presenter, service) {
        };

        LoginController loginController = new LoginController(loginInteractor);

        LoginScreen loginScreen = new LoginScreen(loginController);

        screens.add(loginScreen, "hello");

        cardLayout.show(screens, "login");
        application.pack();
        application.setVisible(true);
    }
}
