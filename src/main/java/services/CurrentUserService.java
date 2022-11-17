package services;

import entities.User;

public class CurrentUserService {
    private User current_user;

    public User getCurrentUser(){
        return current_user;
    }

    public void setCurrentUser(User current_user) {
        this.current_user = current_user;
    }

    public void resetCurrentUser(){
        this.current_user = null;
    }

    boolean isLoggedIn() {
        return current_user != null;
    }
}