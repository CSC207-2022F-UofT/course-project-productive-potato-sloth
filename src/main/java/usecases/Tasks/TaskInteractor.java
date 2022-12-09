package usecases.Tasks;

import entities.Tag;
import entities.Task;

/**
 * A facaade class that allows interactions with the Task entity
 */
public class TaskInteractor {

    /**
     * Adds a Tag to a Task
     *
     * @param task The target Task
     * @param tag  The Tag to be added
     */
    public static void addTag(Task task, Tag tag) {
        AddTag addTag = new AddTag(task);
        addTag.addTag(tag);
    }

    /**
     * Removes a Tag from a Task
     *
     * @param task The target Task
     * @param tag  The Tag to remove
     */
    public static void removeTag(Task task, Tag tag) {
        RemoveTag removeTag = new RemoveTag(task);
        removeTag.removeTag(tag);
    }

    /**
     * Edits the name of the Task
     *
     * @param task The target Task
     * @param name The new name
     */
    public static void editTaskName(Task task, String name) {
        EditTask editTask = new EditTask(task);
        editTask.editName(name);
    }

    /**
     * Edits the description of the task
     *
     * @param task        The target Task
     * @param description The description of the Task
     */
    public static void editTaskDescription(Task task, String description) {
        EditTask editTask = new EditTask(task);
        editTask.editDescription(description);
    }

    /**
     * Marks a target task complete
     *
     * @param task The target Task
     */
    public static void markTaskComplete(Task task) {
        MarkTaskComplete markTaskComplete = new MarkTaskComplete(task);
        markTaskComplete.setComplete();
    }

    /**
     * Marks a target task incomplete
     *
     * @param task The target Task
     */
    public static void markTaskIncomplete(Task task) {
        MarkTaskIncomplete markTaskIncomplete = new MarkTaskIncomplete(task);
        markTaskIncomplete.setIncomplete();
    }

    /**
     * Adds a collaborator to a Task
     *
     * @param task The target Task
     *             // @param user The collaborator to be added
     */
    public static void addCollaborator(Task task/*, User collaborator*/) {
        AddCollaborator addCollaborator = new AddCollaborator(task);
//        addCollaborator.addCollaborator(collaborator);
    }

    /**
     * Removes a collaborator from a Task
     *
     * @param task The target Task
     *             // @param collaborator The collaborator to be removed
     */
    public static void removeCollaborator(Task task/*, User collaborator*/) {
        RemoveCollaborator removeCollaborator = new RemoveCollaborator(task);
//      removeCollaborator.removeCollaborator(collaborator);
    }

    /**
     * Removes a Task from a User's task list
     *
     * @param task The task to be removed
     *             // @param user The User to remove the task from
     */
    public static void removeTask(Task task/*, User user*/) {
        RemoveTask removeTask = new RemoveTask(/*user*/);
//      removeTask.removeTask(task);
    }

}
