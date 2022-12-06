package entities;

import entities.Task;
import entities.User;

public interface InvitationInterface {
    public User getSender();

    public User getReceiver();

    public String getSentTime();

    public Task getTask();

    public void setSender(User sender);

    public void setReceiver(User receiver);

    public void setTask(Task task);

    // public void setSentTime(String time?);
}