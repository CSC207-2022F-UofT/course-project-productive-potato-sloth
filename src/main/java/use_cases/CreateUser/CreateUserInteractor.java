package use_cases.CreateUser;

import entities.User;
import entities.Tag;
//import entities.Event;
import entities.Task;
//import entities.Timer;
//import entities.Invitation;

import java.util.List;

public class CreateUserInteractor {

        private String username;
        private String password;
        private List<Tag> tags;
//        private List<Event> events;
        private List<Task> tasks;
//        private List<Timer> timers;
//        private List<Invitation> incomingInvitations;
//        private List<Invitation> outgoingInvitations;
        private boolean calendarView;
        public CreateUserData(String username, String password, List<Tag> tags, /* List<Event> events, List<Task> tasks
        List<Timer> timers, List<Invitation> incomingInvitations, List<Invitation> outgoingInvitations, */
                              boolean calendarView) {
            CreateUserData createUser = new CreateUserData();
            return createUser.
            this.start_time = start_time;
            this.end_time = end_time;
            this.collaborator_usernames = collaborator_usernames;
            this.task = task;
            this.name = name;
            this.repeats = repeats;
            this.frequency = frequency;
            this.tags = tags;
        }
}
