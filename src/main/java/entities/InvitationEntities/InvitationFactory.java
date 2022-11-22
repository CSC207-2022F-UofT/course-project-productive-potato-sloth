package entities.InvitationEntities;

import entities.Task;
import entities.User;

public class InvitationFactory implements InvitationFactoryInterface {
    @Override
    public Invitation create(User sender, User receiver, Task task){return new Invitation(sender, receiver, task);}
}

