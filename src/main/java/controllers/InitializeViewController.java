package controllers;
import services.CurrentUserService;
import entities.User;

public class InitializeViewController {
    public void InitializeViewController(){
        //use the CurrentUserService to get the current user
        CurrentUserService service = new CurrentUserService();
        User current_user = service.getCurrentUser();
        //get current Task from current User
        //call interactor with current task's chatRoom
        /*
        The problem here is knowing which task is the current one being clicked. One possible solution is to
        communicate with the controllers or get information from the adjacent Task area about which button is being
        clicked, but I'll figure it out later.
         */
    }
}
