package useCases.InvitationAcceptOrDecline;

import entities.InvitationEntities.InvitationFactoryInterface;
import entities.Task;
import entities.User;
import entities.InvitationEntities.Invitation;
import gateways.DataAccessInterface;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Use case handling accept and reject (remove) invitations.
 */
public class acceptInvitationsInteractor implements AcceptInvitationInputBoundary {
    // accept an invitation means to take in the sender, receiver, task. Removes invitation from the
    // sender's outgoing list and the receiver's incoming list. Add the receiver to the task's
    // collaborators list
    final AcceptInvitationsOutputBoundary presenter;

    final InvitationFactoryInterface invitationFactory;

    final DataAccessInterface<User> UserDataBaseGateway;

    final DataAccessInterface<Task> TaskDataBaseGateway;

    Task task;

    public acceptInvitationsInteractor(AcceptInvitationsOutputBoundary presenter, InvitationFactoryInterface invitationFactory,
                                       DataAccessInterface<User> UserDataBaseGateway, DataAccessInterface<Task> TaskDataBaseGateway) {
        this.presenter = presenter;
        this.invitationFactory = invitationFactory;
        this.UserDataBaseGateway = UserDataBaseGateway;
        this.TaskDataBaseGateway = TaskDataBaseGateway;
    }


    @Override
    public AcceptInvitationOutputModel acceptInvitations(AcceptInvitationInputModel inputModel){

        User sender = UserDataBaseGateway.get(inputModel.senderGetter()); // get the sender from the database using the unique identifier
        User receiver = UserDataBaseGateway.get(inputModel.receiverGetter()); // get the receiver
        //Task task = TaskDataBaseGateway.get(inputModel.taskGetter());// SOS cant get task this way cuz the current user would be the receiver and the receiver does not have that task

        for (Task t : sender.getTasks()){
            if (Objects.equals(t.getName(), inputModel.taskGetter()))
            {task = t;}
            assert task != null;
        }

        
        Invitation invitation = invitationFactory.create(sender, receiver, task);

        sender.removeOutgoingInvitation(invitation); // remove invitation //IMPORTANT: FIX THE FINDING ALGORITHMS IN user.removeOutgoingInvitation
        receiver.removeIncomingInvitation(invitation); // remove invitation

        if (inputModel.accept & task!= null) {

            //task.addCollaborator(receiver); // call addCollaborator method of task ?? do i call receiver.addTask as well?
                //IMPORTANT: calling .addCollaborator assumes task.collaborators has been initialized as non-null. This is obviously not always true
                //divides into cases: if task.addCollborator is empty then initialize task new ArrayList<>() else then just task.addCollaborator(receiver)
        } else {}

        LocalDateTime time = LocalDateTime.now();
        AcceptInvitationOutputModel outputModel = new AcceptInvitationOutputModel(inputModel.senderGetter(), inputModel.receiverGetter(), inputModel.taskGetter(), inputModel.accept, time.toString());
        return presenter.prepareAcceptView(outputModel);
    }

}
