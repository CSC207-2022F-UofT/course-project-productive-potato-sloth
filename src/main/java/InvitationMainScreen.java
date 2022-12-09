import controllers.acceptInvitationController;
import presenters.acceptInvitationPresenter;
import controllers.sendInvitationController;
import presenters.sendInvitationPresenter;
import screens.specificInvitationScreens.acceptInvitationScreen;
import screens.specificInvitationScreens.sendInvitationScreen;
import entities.InvitationEntities.Invitation;
import entities.InvitationEntities.InvitationFactory;
import entities.InvitationEntities.InvitationFactoryInterface;
import entities.Task;
import entities.User;
import gateways.DataAccessInterface;
import gateways.TaskDatabaseGateway;
import gateways.UserDatabaseGateway;
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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InvitationMainScreen extends JFrame implements ActionListener { //for demo purposes
    static String[] list_of_usernames; // list of usernames of collaborators
    static String[] list_of_tasks;  // list of task names


    static JButton sendInvitationButton;

    static JButton acceptInvitationButton;


    static String[] list_of_sender_usernames; // list of usernames of the senders


    ///////////////////////////////////////////// not needed when merged
    static DataAccessInterface<User> UserDatabaseGateway;
    static DataAccessInterface<Task> TaskDatabaseGateway;

    static CurrentUserService currentUserService;
    static String current_user_username;

    static User userone;
    static User usertwo;
    static User userthree;
    static Task taskone;
    static Task tasktwo;
    static Task taskthree;

    ////////////////////////////////////////////

    public static void setUpDemo(){ //not needed when merged
        User user1 = new User("user1", "password"); // set user1 as the current user
        User user2 = new User("user2", "password");
        User user3 = new User("user3", "password");
        Task task1 = new Task("task1", user1);
        Task task2 = new Task("task2", user2);
        Task task3 = new Task("task3", user3);
        user1.addTask(task1);
        user1.addTask(task2); //user1 has task 1 and 2
        user3.addTask(task3);
        Invitation mockInvitation = new Invitation(user3, user1, task3);
        user1.addIncomingInvitation(mockInvitation); //user1 has an invitation coming from user3 with regards to task 3

        currentUserService = new CurrentUserService();
        currentUserService.setCurrentUser(user1);
        current_user_username = currentUserService.getCurrentUser().getUsername();

        userone = user1;
        usertwo = user2;
        userthree = user3;
        taskone = task1;
        tasktwo = task2;
        taskthree = task3;



        //TaskDatabaseGateway.insert(task1); dont need this cuz task1 is already associated with user1 hence displayed
        //TaskDatabaseGateway.insert(task2); //dont need this cuz task2 is already associated with user1 hence displayed
        //TaskDatabaseGateway.insert(task3); taskdatabase.insert adds task to the user so not the correct use here
    }

    public static void insert(){ // not needed when merged
        UserDatabaseGateway.insert(userone);
        UserDatabaseGateway.insert(usertwo);
        UserDatabaseGateway.insert(userthree);
    }

    public static void setUpUserDatabase() { // not needed when merged


        //////////////////////////////////////////// initialize UserDatabaseGateway

        try {
            UserDatabaseGateway = new UserDatabaseGateway("src/main/java/database/dummyUserFile.ser"); // not sure if the path is right
        } catch (IOException e) {
            throw new RuntimeException("File could not be created");
        }
    }
    public static void setUpTaskDatabase(){ // not needed when merged

        //////////////////////////////////////////// initialize TaskDatabaseGateway

        try {
            TaskDatabaseGateway = new TaskDatabaseGateway(currentUserService, (gateways.UserDatabaseGateway) UserDatabaseGateway);
        } catch (IOException e) {
            throw new RuntimeException("Tasks could not be computed");
        }
    }


    public static void populateInvitationUseCase() { //NEEDED WHEN MERGED - DO NOT DELETE
        //////////////////////////////////////////// populate the list_of_usernames through the UserDatabaseGateway
        List<User> user_list_temp = UserDatabaseGateway.getAll(); // get all users

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
        List<Task> task_list_temp = TaskDatabaseGateway.getAll(); // get all task instances

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




    public InvitationMainScreen(){ // "main screen of both sending and accept invitation use case, acting as both a screen and a main"
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

        setVisible(true);// very important


    }


    public static void main(String[] args) {
        setUpDemo();
        setUpUserDatabase();
        insert();
        setUpTaskDatabase();
        populateInvitationUseCase();

        new InvitationMainScreen(); //gets called inside Welcome Screen

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == sendInvitationButton){
            InvitationOutputBoundary sendInvitationPresenter = new sendInvitationPresenter();
            InvitationFactoryInterface invitationFactory = new InvitationFactory();
            InvitationInputBoundary sendInvitationInteractor = new sendInvitationInteractor(
                    sendInvitationPresenter, invitationFactory, UserDatabaseGateway, TaskDatabaseGateway
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
                    acceptInvitationPresenter, invitationFactory, UserDatabaseGateway, TaskDatabaseGateway
            );
            acceptInvitationController acceptInvitationController = new acceptInvitationController(acceptInvitationInteractor);

            acceptInvitationScreen acceptInvitationFrame = new acceptInvitationScreen(current_user_username, list_of_sender_usernames,
                    acceptInvitationController, UserDatabaseGateway); //todo: decide when and where to call this screen


            acceptInvitationFrame.setVisible(true);
        }


    }
}











