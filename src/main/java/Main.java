import screens.WelcomeScreen;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        WelcomeScreen applicationFrame = new WelcomeScreen();
        // everyone add your buttons and action listener in the WelcomeScreen class

        applicationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        applicationFrame.pack();
        applicationFrame.setVisible(true);

    }

}