package UI.ChatRoom;

import javax.swing.*;
import java.awt.event.ActionListener;

public class SecondaryUI extends JFrame {
    private JPanel mainPanel;
    private JLabel message1Display;
    private JLabel message2Display;
    private JLabel Message3Display;
    private JTextField MsgInputField;
    private JButton PrevButton;
    private JButton NextButton;
    private JButton sendMessageButton;
    private JLabel Msg3TimeStamp;
    private JLabel Msg2TimeStamp;
    private JLabel Msg1TimeStamp;
    private JLabel Msg3UserDisp;
    private JLabel Msg2UserDisp;
    private JLabel Msg1UserDisp;

    public SecondaryUI(){
        setTitle("Test");
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SecondaryUI myUI = new SecondaryUI();
        myUI.setContentPane(myUI.mainPanel);
    }
}
