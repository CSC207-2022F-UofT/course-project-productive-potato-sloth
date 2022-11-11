package entities;

public interface InvitationFactoryInterface {
    Invitation create(User toUser, User fromUser, Task task);
}
