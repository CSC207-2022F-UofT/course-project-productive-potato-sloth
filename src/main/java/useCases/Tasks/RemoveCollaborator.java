package useCases.Tasks;

import entities.Task;

/***
 * A use case which adds a collaborator to a User's Task
 */
public class RemoveCollaborator {

    private final Task task;

    /**
     * Instantiating AddCollaborator with a target task
     *
     * @param task The target task
     */
    public RemoveCollaborator(Task task) {
        this.task = task;
    }

//    public void removeCollaborator(User collaborator) {
//        task.removeCollaborator(collaborator)
//    }
}
