package screens.CreateAccount;

import gateways.UserDataAccessInterface;
import gateways.UserDatabaseGateway;
import screens.LabelTextPanel;
import services.CurrentUserService;
import useCases.CreateAccount.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * A Screen which allows users to create a new Account (User)
 */
public class CreateAccountScreen extends JPanel implements ActionListener {
    JTextField username = new JTextField(20);

    JTextField password = new JTextField(20);

    /**
     * A controller which creates a new User
     */
    CreateAccountController accountController;

    /**
     * Instantiates CreateAccountScreen with the required controller
     *
     * @param controller The controller to create an account (User)
     */
    public CreateAccountScreen(CreateAccountController controller) {

        this.accountController = controller;

        JLabel title = new JLabel("Create Your Account");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel("Enter username"), username);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("Enter password"), password);

        // Creating the confirmation button
        JButton createAccount = new JButton("Create Account");
        JButton cancel = new JButton("Cancel");

        JPanel buttons = new JPanel();
        buttons.add(createAccount);
        buttons.add(cancel);

        createAccount.addActionListener(this);
        cancel.addActionListener(this);

        this.add(title);
        this.add(usernameInfo);
        this.add(passwordInfo);
        this.add(buttons);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }


    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {

        switch (evt.getActionCommand()) {
            case "Create Account": {
                try {
                    CreateAccountResponseModel responseModel = accountController.create(username.getText(),
                            password.getText());
                    JOptionPane.showMessageDialog(this, "User "
                            + "\"" + responseModel.getUsername() + "\"" + " is created.");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e.getMessage());
                }
            }
            case "Cancel": {

            }
        }

    }

}
