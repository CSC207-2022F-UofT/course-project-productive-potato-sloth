package entities;

public class InvitationFactory implements InvitationFactoryInterface {
    @Override
    public Invitation create(User sender, User receiver, Task task){return new Invitation(sender, receiver, task);}
}

