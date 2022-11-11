package entities;

public interface InvitationInterface {
    public User getSender();

    public User getReceiver();

    public String getSentTime();

    public Task getTask();
}
