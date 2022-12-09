package screens.Login;

import screens.LabelTextPanel;
import useCases.Login.LoginResponseModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A Screen which allows users to log in
 */
public class LoginScreen extends JPanel {

    static JFrame application;
    JTextField username = new JTextField(15);
    JTextField password = new JTextField(15);

    /**
     * A controller which logs in a User
     */
    LoginController loginController;


    /**
     * Instantiates LoginScreen with the required controller
     *
     * @param loginController The controller to log in a User
     */
    public LoginScreen(LoginController loginController) {
        this.loginController = loginController;

        JLabel title = new JLabel("Log In / Create Account");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel("Username"), username);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("Password"), password);

        // Creating the confirmation button
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

        this.add(title);
        this.add(usernameInfo);
        this.add(passwordInfo);
        this.add(buttons);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

}
