package entities;

public class InvitationFactory implements InvitationFactoryInterface {
    @Override
    public Invitation create(User toUser, User fromUser, Task task){return new Invitation(toUser, fromUser, task);}
}

