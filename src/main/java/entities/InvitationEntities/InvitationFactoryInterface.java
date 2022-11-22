package entities.InvitationEntities;

import entities.Task;
import entities.User;

public interface InvitationFactoryInterface {
    Invitation create(User sender, User receiver, Task task);
}
