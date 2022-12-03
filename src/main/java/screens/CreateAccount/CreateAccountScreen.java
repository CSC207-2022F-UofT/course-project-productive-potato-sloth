package screens.CreateAccount;

import screens.LabelTextPanel;
import useCases.CreateAccount.CreateAccountResponseModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateAccountScreen extends JPanel implements ActionListener {
    JTextField username = new JTextField(15);

    JTextField password = new JTextField(15);

    CreateAccountController accountController;


 //   public CreateAccountScreen(CreateAccountController controller) {
    public CreateAccountScreen() {

//        this.accountController = controller;

        JLabel title = new JLabel("Create Your Account");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel("Enter username"), username);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("Enter password"), password);

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

//    public static void main(String[] args) {
//        JFrame application  =  new JFrame("Create Account");
//        CardLayout cardLayout = new CardLayout();
//        JPanel screens = new JPanel(cardLayout);
//        application.add(screens);
//
//
//        CreateAccountScreen createAccountScreen = new CreateAccountScreen();
//
//        screens.add(createAccountScreen, "hello");
//
//        cardLayout.show(screens, "create account");
//        application.pack();
//        application.setVisible(true);
//    }
}
