package entities;

public interface InvitationFactoryInterface {
    Invitation create(User sender, User receiver, Task task);
}
