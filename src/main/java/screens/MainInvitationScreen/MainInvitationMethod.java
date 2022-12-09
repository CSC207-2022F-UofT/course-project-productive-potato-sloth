package screens.MainInvitationScreen;


import controllers.acceptInvitationController;
import controllers.sendInvitationController;
import presenters.acceptInvitationPresenter;
import presenters.sendInvitationPresenter;
import screens.specificInvitationScreens.acceptInvitationScreen;
import screens.specificInvitationScreens.sendInvitationScreen;
import entities.InvitationEntities.Invitation;
import entities.InvitationEntities.InvitationFactory;
import entities.InvitationEntities.InvitationFactoryInterface;
import entities.Task;
import entities.User;
import gateways.DataAccessInterface;
import services.CurrentUserService;
import useCases.InvitationAcceptOrDecline.AcceptInvitationInputBoundary;
import useCases.InvitationAcceptOrDecline.AcceptInvitationsOutputBoundary;
import useCases.InvitationAcceptOrDecline.acceptInvitationsInteractor;
import useCases.InvitationSending.InvitationInputBoundary;
import useCases.InvitationSending.InvitationOutputBoundary;
import useCases.InvitationSending.sendInvitationInteractor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**The main method of the invitation use cases. This will get called in the master main method to initialize everything*/
public class MainInvitationMethod extends JFrame implements ActionListener {
    static String[] list_of_usernames; // list of usernames of collaborators
    static String[] list_of_tasks;  // list of task names


    static JButton sendInvitationButton;

    static JButton acceptInvitationButton;


    static String[] list_of_sender_usernames; // list of usernames of the senders


    ///////////////////////////////////////////// not needed when merged
    static DataAccessInterface<User> userDatabaseGateway;
    static DataAccessInterface<Task> taskDatabaseGateway;

    static CurrentUserService currentUserService;
    static String current_user_username;


    ////////////////////////////////////////////

    public MainInvitationMethod(DataAccessInterface<User> userGateway, DataAccessInterface<Task> taskGateway,
                                CurrentUserService userService){
        userDatabaseGateway = userGateway;
        taskDatabaseGateway = taskGateway;
        currentUserService = userService;


        populateInvitationUseCase();
        createScreen();

    }


    public static void populateInvitationUseCase() { //NEEDED WHEN MERGED - DO NOT DELETE
        //////////////////////////////////////////// populate the list_of_usernames through the UserDatabaseGateway
        List<User> user_list_temp = userDatabaseGateway.getAll(); // get all users

        ArrayList<String> temp_array_list = new ArrayList<>(); //temporary array
        for (User user : user_list_temp) //for each user
        {
            String username = user.getUsername();

            if (!Objects.equals(username, current_user_username)) {
                temp_array_list.add(username);//for each user, get the username (except the current user)
                // and store it in the temp. array

            }
        }
        list_of_usernames = temp_array_list.toArray(new String[0]); // populate list_of_users

        /////////////////////////////////////////////populate the list_of_tasks through the TaskDatabaseGateway
        List<Task> task_list_temp = taskDatabaseGateway.getAll(); // get all task instances

        ArrayList<String> temp_array_list1 = new ArrayList<>(); //temporary array
        for (Task task : task_list_temp) //for each task
        {
            String task_name = task.getName();

            temp_array_list1.add(task_name);//for each task, get the task_name
            // and store it in the temp. array
        }
        list_of_tasks = temp_array_list1.toArray(new String[0]); // populate list_of_task
        System.out.print(list_of_tasks.length); // bug check


        ///////////////////////////////////////////// populate list_of_sender_usernames
        User current_user = currentUserService.getCurrentUser(); // get the current user

        List<Invitation> invitation_list = current_user.getIncomingInvitations(); //get list of incoming invitations from current user

        ArrayList<String> temp_array_list2 = new ArrayList<>(); //temporary array
        for (Invitation invitation : invitation_list) {
            String sender_username = invitation.getSender().getUsername();

            temp_array_list2.add(sender_username);//for each incoming invitation from the current user, get the username of the sender
            // and store it in the temp. array
        }
        list_of_sender_usernames = temp_array_list2.toArray(new String[0]); // populate list_of_sender_username
    }




    public void createScreen(){ // "main screen of both sending and accept invitation use case, acting as both a screen and a main"
        JLabel welcomeText = new JLabel("WELCOME");
        setLayout(new GridLayout());
        setSize(400, 500);
        setTitle("INVITATION MANAGEMENT");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        sendInvitationButton = new JButton("Send Invitation");
        sendInvitationButton.addActionListener(this);
        this.add(sendInvitationButton);

        acceptInvitationButton = new JButton("Accept or Decline Invitation");
        acceptInvitationButton.addActionListener(this);
        this.add(acceptInvitationButton);

        setVisible(false);// very important


    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == sendInvitationButton){
            InvitationOutputBoundary sendInvitationPresenter = new sendInvitationPresenter();
            InvitationFactoryInterface invitationFactory = new InvitationFactory();
            InvitationInputBoundary sendInvitationInteractor = new sendInvitationInteractor(
                    sendInvitationPresenter, invitationFactory, userDatabaseGateway, taskDatabaseGateway
            );
            sendInvitationController sendInvitationController = new sendInvitationController(sendInvitationInteractor);
            sendInvitationScreen sendInvitationFrame = new sendInvitationScreen(current_user_username, list_of_usernames,
                    list_of_tasks, sendInvitationController); //todo: decide when and where to call this screen

            sendInvitationFrame.setVisible(true);
        }

        if (e.getSource() == acceptInvitationButton){
            AcceptInvitationsOutputBoundary acceptInvitationPresenter = new acceptInvitationPresenter();
            InvitationFactoryInterface invitationFactory = new InvitationFactory();
            AcceptInvitationInputBoundary acceptInvitationInteractor = new acceptInvitationsInteractor(
                    acceptInvitationPresenter, invitationFactory, userDatabaseGateway, taskDatabaseGateway
            );
            acceptInvitationController acceptInvitationController = new acceptInvitationController(acceptInvitationInteractor);

            acceptInvitationScreen acceptInvitationFrame = new acceptInvitationScreen(current_user_username, list_of_sender_usernames,
                    acceptInvitationController, userDatabaseGateway); //todo: decide when and where to call this screen


            acceptInvitationFrame.setVisible(true);
        }


    }
}











