import entities.Task;
import entities.User;
import gateways.DataAccessInterface;
import gateways.TaskDatabaseGateway;
import gateways.UserDatabaseGateway;
import screens.MainInvitationScreen.MainInvitationMethod;
import screens.WelcomeScreen;
import services.CurrentUserService;

import javax.swing.*;
import java.io.IOException;

public class Main {
    static DataAccessInterface<User> userGateway; //
    static DataAccessInterface<Task> taskGateway; //
    static CurrentUserService current_user_service;

    public static void main(String[] args) throws IOException {

        userGateway = new UserDatabaseGateway("dummyUserFile");
        taskGateway = new TaskDatabaseGateway(current_user_service, (UserDatabaseGateway) userGateway);


        MainInvitationMethod main_invitation = new MainInvitationMethod(userGateway, taskGateway, current_user_service);

        WelcomeScreen applicationFrame = new WelcomeScreen(main_invitation);
        //everyone add your buttons and action listener in the WelcomeScreen class

        applicationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        applicationFrame.pack();
        applicationFrame.setVisible(true);


    }

}