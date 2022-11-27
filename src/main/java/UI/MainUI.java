package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controllers.SendMessageController;
import controllers.UpdateViewPresenter;
import services.CurrentUserService;
import useCases.ChatRoomInteractor;
import services.CurrentUserService;

public class MainUI {
    public SendMessageController messenger;
    public ChatRoomInteractor interactor;
    private JLabel message1Display;
    private JLabel message2Display;
    private JLabel Message3Display;
    private JTextField MsgInputField;
    private JButton PrevButton;
    private JButton NextButton;
    private JButton sendMessageButton;
    private JLabel Msg3UserDisp;
    private JLabel Msg3TimeStamp;
    private JLabel Msg2TimeStamp;
    private JLabel Msg2UserDisp;
    private JLabel Msg1TimeStamp;
    private JPanel Msg1UserDisp;

    public MainUI(ChatRoomInteractor interactor) {
        this.interactor = interactor;
        this.messenger = new SendMessageController(interactor);
        CurrentUserService service = new CurrentUserService();
        sendMessageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                MainUI.this.messenger.sendMessageController(MsgInputField.getText(), service.getCurrentUser());
            }
        });
        NextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        PrevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }
}
