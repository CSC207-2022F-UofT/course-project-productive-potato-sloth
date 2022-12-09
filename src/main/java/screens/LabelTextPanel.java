package screens;

import javax.swing.*;

// Frameworks/Drivers layer

/**
 * A text panel that serves as a label and which also contains
 * a text field.
 */
public class LabelTextPanel extends JPanel {
    public LabelTextPanel(JLabel label, JTextField textField) {
        this.add(label);
        this.add(textField);
    }
}