package entities;
import entities.InvitationEntities.Invitation;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**Test couldn't be run as some entities are not yet implemented*/
public class InvitationTest {
    String sentTime;

    User sender;
    User receiver;
    Task task;

    public Invitation invitation;


    @Before

    public void setUp() {


        sender = new User("sender", "senderPassword"); // User(String username, String password)
        receiver = new User("receiver", "receiverPassword"); // User(String username, String password)
        task = new Task("task1", sender); // Task(String name, User user)
        invitation = new Invitation(sender, receiver, task);
    }

    @Test
    public void testInvitationGetSenderMatching(){
        invitation = new Invitation(sender, receiver, task);
        Assertions.assertEquals(sender, invitation.getSender());
    }

    @Test
    public void testInvitationGetReceiverMatching(){
        invitation = new Invitation(sender, receiver, task);
        Assertions.assertEquals(receiver, invitation.getReceiver());
    }

    @Test
    public void testInvitationGetTaskMatching(){
        invitation = new Invitation(sender, receiver, task);
        Assertions.assertEquals(task, invitation.getTask());
    }

    @Test
    public void testInvitationSetSender(){
        invitation = new Invitation(sender, receiver, task);
        User random = new User("randomUser", "randomPassword");
        invitation.setSender(random);
        Assertions.assertEquals(random, invitation.getSender());
    }

    @Test
    public void testInvitationSetReceiver(){
        invitation = new Invitation(sender, receiver, task);
        User random = new User("randomUser", "randomPassword");
        invitation.setReceiver(random);
        Assertions.assertEquals(random, invitation.getReceiver());
    }

    @Test
    public void testInvitationSetTask(){
        invitation = new Invitation(sender, receiver, task);
        User randomUser = new User("randomUser", "randomPassword");
        Task random = new Task("randomTask", randomUser);
        invitation.setTask(random);
        Assertions.assertEquals(random, invitation.getTask());;
    }

    }




