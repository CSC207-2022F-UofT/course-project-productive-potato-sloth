package screens.Login;

import gateways.UserDataAccessInterface;
import gateways.UserDatabaseGateway;
import screens.CreateAccount.CreateAccount.CreateAccountScreen;
import screens.CreateAccount.CreateAccountController;
import screens.CreateAccount.CreateAccountResponseFormatter;
import screens.LabelTextPanel;
import services.CurrentUserService;
import useCases.CreateAccount.CreateAccountInputBoundary;
import useCases.CreateAccount.CreateAccountInteractor;
import useCases.CreateAccount.CreateAccountPresenter;
import useCases.CreateAccount.CreateAccountResponseModel;
import useCases.Login.LoginInputBoundary;
import useCases.Login.LoginInteractor;
import useCases.Login.LoginPresenter;
import useCases.Login.LoginResponseModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LoginScreen extends JPanel {

    static JFrame application;
    JTextField username = new JTextField(15);
    JTextField password = new JTextField(15);

    LoginController loginController;


    /**
     * A window with a title and a JButton.
     */
    public LoginScreen(LoginController loginController) {
        this.loginController = loginController;

        JLabel title = new JLabel("Log In / Create Account");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel("Username"), username);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("Password"), password);

        JButton logIn = new JButton("Log In");
        JButton createAccount = new JButton("Create Account");

        JPanel buttons = new JPanel();
        buttons.add(logIn);
        buttons.add(createAccount);

        logIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    LoginResponseModel responseModel = loginController.create(username.getText(),
                            password.getText());
                    JOptionPane.showMessageDialog(application, "User "
                            + "\"" + responseModel.getUsername() + "\"" + " is logged in.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(application, ex.getMessage());
                }
            }
        });
        createAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateAccountScreen createAccountScreen = new CreateAccountScreen();

            }
        });

        this.add(title);
        this.add(usernameInfo);
        this.add(passwordInfo);
        this.add(buttons);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }


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
