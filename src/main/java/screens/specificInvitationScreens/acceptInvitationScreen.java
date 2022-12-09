package screens.specificInvitationScreens;
import controllers.acceptInvitationController;

import entities.Task;
import entities.User;
import gateways.DataAccessInterface;
import useCases.InvitationAcceptOrDecline.AcceptInvitationOutputModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class acceptInvitationScreen extends JFrame implements ActionListener{

    String current_user_username; // the receiver's username
    acceptInvitationController acceptInvitationController; // the controller

    String[] list_of_sender_usernames; // list of usernames of the potential collaborators (the incoming invitations)

    String[] list_of_task_names_from_sender; // list of task names retrieved from the CHOSEN sender

    JComboBox<String> senderChoices;  // the dropdown list of sender usernames

    JComboBox<String> taskChoices;  // the dropdown list of task names sent by THE CHOSEN SENDER

    JButton acceptInvitationButton = new JButton("Accept invitation"); //button that calls the controller's method when clicked (accept = yes)

    JButton declineInvitationButton = new JButton("Decline invitation"); // button that calls the controller's method when click (accept = no)

    String sender_choice; // the username of the chosen collaborator
    String task_choice; // the name of the chosen task

    AcceptInvitationOutputModel returned_model;

    DataAccessInterface<User> UserDatabaseGateway;


    public acceptInvitationScreen(String current_user_username, String[] list_of_sender_usernames,
                                acceptInvitationController acceptInvitationController, DataAccessInterface<User> UserDatabaseGateway
    ){
        this.current_user_username = current_user_username; // the receiver's username == the current user's username
        this.list_of_sender_usernames = list_of_sender_usernames;
        this.acceptInvitationController = acceptInvitationController;
        this.UserDatabaseGateway = UserDatabaseGateway;

        //////////////////////////////////////////////////////


        setLayout(new FlowLayout() );
        setSize(800, 300);
        setTitle("Accept or Decline Invitation");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        System.out.println(this.list_of_sender_usernames.length);
        if (this.list_of_sender_usernames.length == 0) {
            JOptionPane.showMessageDialog(this, "No invitations found. Check back often!");
        } else{

        JLabel prompt = new JLabel("These users sent you an invitation! Choose a user:");
        add(prompt);
        senderChoices = new JComboBox<>(this.list_of_sender_usernames); // populate the drop-down list of senders
//      senderChoices.setSelectedIndex(0); comment out b/c what if senderChoices is empty
        senderChoices.addActionListener(this);
        add(senderChoices);



        acceptInvitationButton.addActionListener(this);
        declineInvitationButton.addActionListener(this);
        add(acceptInvitationButton);
        add(declineInvitationButton);
        //////////////////////////////////////////////////

    }}


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click " + e.getActionCommand()); // for debugging purposes

        if (e.getSource() == senderChoices){
            sender_choice = (String) senderChoices.getSelectedItem();

            User sender = UserDatabaseGateway.get(sender_choice); // get the sender (type User)
            List<Task> list_of_sender_tasks = sender.getTasks(); // get the list of tasks associated with the chosen sender

            ArrayList<String> temp = new ArrayList<>();
            for (Task task: list_of_sender_tasks){
                String task_name = task.getName();
                temp.add(task_name);
            }

            this.list_of_task_names_from_sender = temp.toArray(new String[0]); // populate the task names (task identifiers) from the sender

            taskChoices = new JComboBox<>(this.list_of_task_names_from_sender); //add the tasks dropdown list
            taskChoices.addActionListener(this);

            add(taskChoices);
        }

        if (e.getSource() == taskChoices){
            System.out.println("Task clicked");
            task_choice = (String) taskChoices.getSelectedItem();
        }

        if (e.getSource() == acceptInvitationButton & (sender_choice != null) & task_choice != null){  //when the button is clicked, makes sure sender and task were chosen
            boolean accept = true;

            this.returned_model = this.acceptInvitationController.acceptInvitations(
                    sender_choice, current_user_username,
                    task_choice, accept); // call the controller with accept = true and
            // get the presenter's returned view model through the controller

            String message = "You successfully accepted " + this.returned_model.senderGetter() + "'s invitation for the task "
                    + this.returned_model.taskGetter() + " at "
                    + this.returned_model.getTimeResponded();

            JOptionPane.showMessageDialog(this, message);
        }

        if (e.getSource() == declineInvitationButton & (sender_choice != null) & task_choice != null){  //when the button is clicked, makes sure sender and task were chosen
            boolean accept = false;

            this.returned_model = this.acceptInvitationController.acceptInvitations(
                    sender_choice, current_user_username,
                    task_choice, accept); // call the controller with accept = false and
            // get the presenter's returned view model through the controller

            String message = "You declined " + this.returned_model.senderGetter() + "'s invitation for the task "
                    + this.returned_model.taskGetter() + " at "
                    + this.returned_model.getTimeResponded();

            JOptionPane.showMessageDialog(this, message);
        }

    }
}

