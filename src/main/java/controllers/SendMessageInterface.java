package controllers;

import entities.User;

public interface SendMessageInterface {
    public void sendMessageController(String message, User user);
}
