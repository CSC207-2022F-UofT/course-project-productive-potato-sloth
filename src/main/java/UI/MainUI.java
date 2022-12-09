package UI;

import controllers.ChatRoomControllers.SendMessageController;
import controllers.ChatRoomControllers.UpdateViewController;
import useCases.ChatRoom.ChatRoomInteractorInterface;
import useCases.responseModels.MessageResponseModel;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * This is the UI for the ChatRoom. Please ignore the 73 errors IntelliJ shows because
 * the errors all come from automatically generated code, which I cannot change (if I changed it, next time the UI is
 * rendered, the errors will be back). The UI works fine, so they are nothing to worry about.
 *
 * The UI class uses JFrame to render the user interface.
 */
public class MainUI extends JFrame {
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
    /**
     * The Organizer is something that needs to be set up every time the UI is initialized, by ResponseSetUp().
     * It is a way of grouping the labels for username, timestamp and message content on the screen so that
     * updating the screens do not require a lot of repeated code. See more at the Javadoc for ResponseSetUp().
     */
    private List<List<JLabel>> organizer;

    /**
     * Here is the constructor method. It takes in a SendMessageController that is already associated with the
     * interactor in order to initialize the UI. There are several helper methods.
     * @param messenger: a SendMessageController object that is associated with the interactor. The SendMessage-
     *                 -Controller does not have a reference to the UI, so it has to be passed into the UI
     *                 for the UI to call it.
     */
    public MainUI(SendMessageController messenger) {
        this.interactor = messenger.getInteractor();
        this.messenger = messenger;
//        $$$setupUI$$$();
        this.organizer = responseSetUp();
        this.updater = new UpdateViewController(this.interactor);
        //This line sets the content to be same as the MainUI.form file.
        //Without it, the UI will render as blank.
        setContentPane(this.mainPanel);
        //program will terminate when window is closed
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //below two lines are for setting the UI as visible
        this.pack();
        this.setVisible(true);
        /**
         * ActionListener method for the "send message" button. This method gets text from the message input field
         * (a JTextField where users type their message in) and passes it onto  the controller if the field is not
         * empty.
         */
        sendMessageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!(MsgInputField.getText().equals(""))) {
                    MainUI.this.messenger.sendMessageController(MsgInputField.getText());
                }
            }
        });
        /**
         * The two methods below are the listeners for the "scroll down/up" button. It passes a boolean into the
         * controller to tell it to scroll to more recent messages or older messages. See the javadoc of
         * UpdateViewController for more details.
         */
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
     *
     * @param model: a List of MessageResponseModels, ordered from old to new.
     */
    public void setMessages(List<MessageResponseModel> model) {
        int i = 0;
        for (MessageResponseModel msg : model) {
            List<JLabel> temp_index = this.organizer.get(i);
            temp_index.get(0).setText(msg.getContent());
            temp_index.get(1).setText(msg.getAuthor());
            temp_index.get(2).setText(msg.getTimeStamp());
            i++;
        }
        if (i < 2) {
            while (i < 3) {
                List<JLabel> temp_index = this.organizer.get(i);
                temp_index.get(0).setText("Message unavailable");
                temp_index.get(1).setText("No author");
                temp_index.get(2).setText("No timestamp");
                i++;
            }
        }
    }

    /**
     * Helper method that returns a List with 3 elements, with each element containing 3 JLabels in the form
     * Display, Username, Timestamp. This is for helping the output update the View so that I
     * can make the code more modular.
     * The elements are organized from top to bottom. This way if there are less than 3 messages on screen,
     * then the bottom part of the screen would be blank.
     */
    private List<List<JLabel>> responseSetUp() {
        List<JLabel> panel3List = new ArrayList<>();
        panel3List.add(this.Message3Display);
        panel3List.add(this.Msg3UserDisp);
        panel3List.add(this.Msg3TimeStamp);
        List<JLabel> panel2List = new ArrayList<>();
        panel2List.add(this.Message2Display);
        panel2List.add(this.Msg2UserDisp);
        panel2List.add(this.Msg2TimeStamp);
        List<JLabel> panel1List = new ArrayList<>();
        panel1List.add(this.Message1Display);
        panel1List.add(this.Msg1UserDisp);
        panel1List.add(this.Msg1TimeStamp);
        List<List<JLabel>> panelList = new ArrayList<>();
        panelList.add(panel1List);
        panelList.add(panel2List);
        panelList.add(panel3List);
        return panelList;
    }

    /**
     * @noinspection ALL
     */
}

