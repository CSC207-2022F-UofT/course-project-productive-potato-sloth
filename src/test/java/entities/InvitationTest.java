package entities;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.*;

public class InvitationTest {
    String sentTime;

    User sender;
    User receiver;
    Task task;

    Invitation invitation;


    @Before

    public void setUp() {


        sender = new User("sender", "senderPassword"); // User(String username, String password)
        receiver = new User("receiver", "receiverPassword"); // User(String username, String password)
        task = new Task("task1", sender); // Task(String name, User user)
        invitation = new Invitation(sender, receiver, task);
    }

    @Test
    public void testInvitationGetSenderMatching(){
        Assertions.assertEquals(sender, invitation.getSender());
    }

    @Test
    public void testInvitationGetReceiverMatching(){
        Assertions.assertEquals(receiver, invitation.getReceiver());
    }

    @Test
    public void testInvitationGetTaskMatching(){
        Assertions.assertEquals(task, invitation.getTask());
    }

    @Test
    public void testInvitationSetSender(){
        User random = new User("randomUser", "randomPassword");
        invitation.setSender(random);
        Assertions.assertEquals(random, invitation.getSender());
    }

    @Test
    public void testInvitationSetReceiver(){
        User random = new User("randomUser", "randomPassword");
        invitation.setReceiver(random);
        Assertions.assertEquals(random, invitation.getReceiver());
    }

    @Test
    public void testInvitationSetTask(){
        User randomUser = new User("randomUser", "randomPassword");
        Task random = new Task("randomTask", randomUser);
        invitation.setTask(random);
        Assertions.assertEquals(random, invitation.getTask());;
    }

    }


//    @Test
//    public void testInvitationConstructor(){
//        Assertions.assertEquals(sender, invitation.getSender());
//        Assertions.assertEquals(receiver, invitation.getReceiver());
//        Assertions.assertEquals(task, invitation.getTask());
//
//    } -> basically the same thing as above?




