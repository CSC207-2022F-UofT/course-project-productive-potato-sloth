package entities.InvitationEntities;

import entities.Task;
import entities.User;

import java.io.Serializable;

public class InvitationFactory implements Serializable, InvitationFactoryInterface {
    @Override
    public Invitation create(User sender, User receiver, Task task){return new Invitation(sender, receiver, task);}
}

