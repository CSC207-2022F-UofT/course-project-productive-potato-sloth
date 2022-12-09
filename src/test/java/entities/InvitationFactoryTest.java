package entities;
import entities.InvitationEntities.Invitation;
import entities.InvitationEntities.InvitationFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class InvitationFactoryTest {
    static InvitationFactory invitationFactory;
    static Invitation invitation1;
    static Invitation invitation2;
    static User sender;
    static User receiver;
    static Task task;


    @BeforeAll
    public static void InitializeTestAttributes() {
        sender = new User("sender", "senderPassword"); // User(String username, String password)
        receiver = new User("receiver", "receiverPassword"); // User(String username, String password)
        task = new Task("task1", sender); // Task(String name, User user)

    }


    @BeforeAll
    public static void CreateInvitationfromInvitationFactory() {
        invitationFactory = new InvitationFactory();

        invitation1 = invitationFactory.create(sender, receiver, task);


    }

    @BeforeAll
    public static void CreateInvitationUsingConstructor() {
        invitation2 = new Invitation(sender, receiver, task);

    }

    @Test
    public void TestTwoInvitationsHaveSimilarSender() {
        Assertions.assertEquals(invitation1.getSender(), invitation2.getSender());
    }

    @Test
    public void TestTwoInvitationsHaveSimilarReceiver() {
        Assertions.assertEquals(invitation1.getReceiver(), invitation2.getReceiver());
    }


    @Test
    public void TestTwoInvitationsHaveDifferentReceiver() {
        invitation1 = new Invitation(sender, receiver, task);
        task = new Task("hi", sender);
        invitation2 = new Invitation(sender, receiver, task);
        Assertions.assertNotEquals(invitation1.getTask(), invitation2.getTask());
    }

    @Test
    public void TestTwoInvitationsHaveSimilarTask() {
        invitation1 = new Invitation(sender, receiver, task);
        invitation2 = invitationFactory.create(sender, receiver, task);
        Assertions.assertEquals(invitation1.getReceiver(), invitation2.getReceiver());
    }
}