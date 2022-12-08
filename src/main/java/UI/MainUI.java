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

    private List<List<JLabel>> organizer;

    public MainUI(ChatRoomInteractorInterface interactor, SendMessageController messenger) {
        this.interactor = interactor;
        this.messenger = messenger;
        $$$setupUI$$$();
        this.organizer = responseSetUp();
        this.updater = new UpdateViewController(this.interactor);
        setContentPane(this.mainPanel);
        //end of experimental segment
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        sendMessageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!(MsgInputField.getText().equals(""))) {
                    MainUI.this.messenger.sendMessageController(MsgInputField.getText());
                }
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
                temp_index.get(0).setText("entities.Message unavailable");
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
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(7, 3, new Insets(0, 0, 0, 0), -1, -1));
        Message1Display = new JLabel();
        Message1Display.setBackground(new Color(-12828863));
        Font Message1DisplayFont = this.$$$getFont$$$(null, -1, 26, Message1Display.getFont());
        if (Message1DisplayFont != null) Message1Display.setFont(Message1DisplayFont);
        Message1Display.setForeground(new Color(-4473925));
        Message1Display.setText("Message unavailable");
        mainPanel.add(Message1Display, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(451, 36), null, 0, false));
        Message2Display = new JLabel();
        Font Message2DisplayFont = this.$$$getFont$$$(null, -1, 24, Message2Display.getFont());
        if (Message2DisplayFont != null) Message2Display.setFont(Message2DisplayFont);
        Message2Display.setText("Message unavailable");
        mainPanel.add(Message2Display, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(451, 95), null, 0, false));
        Message3Display = new JLabel();
        Font Message3DisplayFont = this.$$$getFont$$$(null, -1, 24, Message3Display.getFont());
        if (Message3DisplayFont != null) Message3Display.setFont(Message3DisplayFont);
        Message3Display.setText("Message unavailable");
        mainPanel.add(Message3Display, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(451, 168), null, 0, false));
        MsgInputField = new JTextField();
        MsgInputField.setText("Input your message here...");
        MsgInputField.setToolTipText("Enter your message here");
        mainPanel.add(MsgInputField, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(451, 30), null, 0, false));
        PrevButton = new JButton();
        PrevButton.setText("Prev Message");
        PrevButton.setToolTipText("older messages");
        mainPanel.add(PrevButton, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        NextButton = new JButton();
        NextButton.setText("Next Message");
        NextButton.setToolTipText("newer messages");
        mainPanel.add(NextButton, new com.intellij.uiDesigner.core.GridConstraints(5, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(108, 168), null, 0, false));
        sendMessageButton = new JButton();
        sendMessageButton.setText("Send Message");
        mainPanel.add(sendMessageButton, new com.intellij.uiDesigner.core.GridConstraints(6, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        Msg3TimeStamp = new JLabel();
        Msg3TimeStamp.setText("Time");
        mainPanel.add(Msg3TimeStamp, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        Msg2TimeStamp = new JLabel();
        Msg2TimeStamp.setText("Time");
        mainPanel.add(Msg2TimeStamp, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        Msg1TimeStamp = new JLabel();
        Msg1TimeStamp.setText("Time");
        mainPanel.add(Msg1TimeStamp, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        Msg3UserDisp = new JLabel();
        Msg3UserDisp.setText("Retrieving User...");
        mainPanel.add(Msg3UserDisp, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        Msg2UserDisp = new JLabel();
        Msg2UserDisp.setText("Retrieving User...");
        mainPanel.add(Msg2UserDisp, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        Msg1UserDisp = new JLabel();
        Msg1UserDisp.setText("Retrieving User...");
        mainPanel.add(Msg1UserDisp, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }

    /**
     * @noinspection ALL
     */
}

