package usecases.Tasks;

import entities.Task;

/***
 * A use case which adds a collaborator to a User's Task
 */
public class AddCollaborator {

    private final Task task;

    /**
     * Instantiating AddCollaborator with a target task
     *
     * @param task The target task
     */
    public AddCollaborator(Task task) {
        this.task = task;
    }

//    public void addCollaborator(User collaborator) {
//        task.addCollaborator(collaborator)
//    }

}
