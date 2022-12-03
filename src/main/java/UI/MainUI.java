package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import controllers.ChatRoomControllers.SendMessageController;
import controllers.ChatRoomControllers.UpdateViewController;
import services.CurrentUserService;
import useCases.ChatRoom.ChatRoomInteractorInterface;
import useCases.responseModels.MessageResponseModel;

public class MainUI {
    public SendMessageController messenger;
    public ChatRoomInteractorInterface interactor;

    public UpdateViewController updater;
    private JLabel Message1Display;
    private JLabel Message2Display;
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
    private JPanel mainPanel;
    private JLabel Msg1UserDisp;
    private JLabel message1Display;
    private JLabel message2Display;

    private List<List<JLabel>> organizer;

    public MainUI(ChatRoomInteractorInterface interactor, SendMessageController messenger) {
        this.interactor = interactor;
        this.messenger = messenger;
        this.organizer = responseSetUp();
        this.updater = new UpdateViewController(this.interactor);
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
                MainUI.this.updater.UpdateViewController(false);
            }
        });
        PrevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                MainUI.this.updater.UpdateViewController(true);
            }
        });

    }

    /**
     * This is the output that directly updates to the screen. The presenter, in its finished
     * state, will call this method and update directly to the screen. If there are less than 3 messages put in
     * then the method will fill the uncompleted messages with "unavailable" responses.
     * Precondition: len(model) <= 3. This is already ensured in the Presenter.
     * @param model: a List of MessageResponseModels, ordered from old to new.
     */
    public void setMessages(List<MessageResponseModel> model){
        int i = 0;
        for (MessageResponseModel msg : model){
            List<JLabel> temp_index = this.organizer.get(i);
            temp_index.get(0).setText(msg.getContent());
            temp_index.get(1).setText(msg.getAuthor());
            temp_index.get(2).setText(msg.getTimeStamp());
            i++;
        }
        if(i < 2){
            while(i < 3){
                List<JLabel> temp_index = this.organizer.get(i);
                temp_index.get(0).setText("Message unavailable");
                temp_index.get(1).setText("No author");
                temp_index.get(2).setText("No timestamp");
                i++;
            }
        }
    }
    /**
    Helper method that returns a List with 3 elements, with each element containing 3 JLabels in the form
     Display, Username, Timestamp. This is for helping the output update the View so that I
     can make the code more modular.
     The elements are organized from top to bottom. This way if there are less than 3 messages on screen,
     then the bottom part of the screen would be blank.
     */
    private List<List<JLabel>> responseSetUp(){
        if(this.organizer != null) {
            return this.organizer;
        }
        else{
            List<JLabel> panel3List = new ArrayList<>();
            panel3List.add(this.Message3Display);
            panel3List.add(this.Msg3UserDisp);
            panel3List.add(this.Msg3TimeStamp);
            List<JLabel> panel2List = new ArrayList<>();
            panel2List.add(this.Message2Display);
            panel2List.add(this.Msg2UserDisp);
            panel2List.add(this.Msg2TimeStamp);
            List<JLabel> panel1List = new ArrayList<>();
            panel3List.add(this.Message1Display);
            panel3List.add(this.Msg1UserDisp);
            panel3List.add(this.Msg1TimeStamp);
            List<List<JLabel>> panelList = new ArrayList<>();
            panelList.add(panel1List);
            panelList.add(panel2List);
            panelList.add(panel3List);
            return panelList;
        }
    }
}

