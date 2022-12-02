package useCases.responseModels;
import entities.User;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.*;
import entities.Message;

public class MessageResponseModelTest {
    @Before
    public void SetUp(){
    }
    User user1 = new User();
    Message message = new Message("abcd", user1);

    @After
    public void TearDown(){
    }

    @Test
    public void TestResponseModel(){
        MessageResponseModel model = new MessageResponseModel(message);
        String dateTime = String.valueOf((message.getDateTime().getHour()) +
                (message.getDateTime().getMinute()));
        Assertions.assertEquals(model.getContent(), message.toString());
        Assertions.assertEquals(model.getAuthor(), message.getAuthor());
        Assertions.assertEquals(model.getTimeStamp(), dateTime);
    }
}
