package screens.Login;

import screens.LabelTextPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JPanel implements ActionListener {
    JTextField username = new JTextField(15);
    JTextField password = new JTextField(15);

    /**
     * A window with a title and a JButton.
     */
    public LoginScreen() {

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

        logIn.addActionListener(this);
        createAccount.addActionListener(this);

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
        System.out.println("Click " + evt.getActionCommand());
    }

    public static void main(String[] args) {
        JFrame application  =  new JFrame("Log In");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

        LoginScreen loginScreen = new LoginScreen();

        screens.add(loginScreen, "hello");

        cardLayout.show(screens, "login");
        application.pack();
        application.setVisible(true);
    }

}
