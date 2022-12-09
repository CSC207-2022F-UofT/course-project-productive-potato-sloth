package screens.specificInvitationScreens;
import controllers.sendInvitationController;
import useCases.InvitationSending.InvitationOutputModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class sendInvitationScreen extends JFrame implements ActionListener{

    String current_user_username; 
    sendInvitationController sendInvitationController; // the controller

    String[] list_of_usernames; // list of usernames of collaborators

    String[] list_of_tasks; // list of tasks

    JComboBox<String> userChoices;  // the dropdown list of receiver usernames

    JComboBox<String> taskChoices;  // the dropdown list of task names
    
    JButton sendInvitationButton; //button that calls the controller's method when clicked

    String user_choice; // the username of the chosen collaborator
    String task_choice; // the name of the chosen task

    InvitationOutputModel returned_model;

    public boolean refresh = false;

    public sendInvitationScreen(String current_user_username, String[] list_of_usernames, String[] list_of_tasks,
                                    sendInvitationController sendInvitationcontroller
                                    ){
        this.current_user_username = current_user_username;
        this.list_of_usernames = list_of_usernames;
        this.list_of_tasks = list_of_tasks;

        userChoices = new JComboBox<>(list_of_usernames);
        taskChoices = new JComboBox<>(list_of_tasks);
        this.sendInvitationController = sendInvitationcontroller;
        //////////////////////////////////////////////////////


        setLayout(new FlowLayout());
        setSize(400, 300);
        setTitle("Send Invitation");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel welcomeText= new JLabel("Hi " + current_user_username +" !");
        this.add(welcomeText);

        if (userChoices != null){
        userChoices.setSelectedIndex(0);
        userChoices.addActionListener(this);
        add(new JLabel("Choose your collaborator: "));
        add(userChoices);}

        if (taskChoices != null){
        taskChoices.setSelectedIndex(0);
        taskChoices.addActionListener(this);
        add(new JLabel("     Choose a task:  "));
        add(taskChoices);}

        sendInvitationButton = new JButton("Send invitation");
        sendInvitationButton.addActionListener(this);
        this.add(sendInvitationButton);


        //////////////////////////////////////////////////

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click " + e.getActionCommand()); // for debugging purposes

        
        if (e.getSource() == userChoices){
            user_choice = (String) userChoices.getSelectedItem();
        }
        if (e.getSource() == taskChoices){
            task_choice = (String) taskChoices.getSelectedItem();
        }
        if (e.getSource() == sendInvitationButton ){
            if (user_choice == null || task_choice == null){  //makes sure collaborator and task were chosen
                JOptionPane.showMessageDialog(this, "Make sure both user and task are chosen"); // there is gonna an error shown but no need to handle
            }
            this.returned_model = this.sendInvitationController.sendInvitationControllerMethod(
                   current_user_username, user_choice, task_choice); // get the presenter's returned view model through the controller

            String message = "Your invitation to " + this.returned_model.receiverGetter() + " for the task " + this.returned_model.taskGetter()
                    + " was successfully sent at "
                    + this.returned_model.getTimeSent();

            this.refresh = true;


            JOptionPane.showMessageDialog(this, message);
        }

    }
}
