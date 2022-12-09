package controllers.Tasks;

import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;
import useCases.Tasks.EditTaskInputBoundary;

/**
 * A controller which takes user input relevant to editing a Task description and sends it through the input boundary
 */
public class EditTaskDescriptionController {

    /**
     * The interface which allows access to the EditTask use case
     */
    private final EditTaskInputBoundary inputBoundary;

    /**
     * Creates an instance of EditTaskDescriptionController with the required fields
     *
     * @param inputBoundary Interface for accessing the EditTaskDescription use case
     */
    public EditTaskDescriptionController(EditTaskInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * The method which takes raw input pertaining to editing the description of a Task and returns a Response
     * This method packages the data into a TaskRequestModel first before sending it through the input boundary
     *
     * @param name           The name of the Task
     * @param newDescription The description to be set
     * @return The Response Model containing the new description
     */
    public TaskResponseModel editDescription(String name, String newDescription) {
        TaskRequestModel taskRequestModel = new TaskRequestModel(
                name,
                null,
                newDescription,
                null,
                null,
                null
        );
        return inputBoundary.editDescription(taskRequestModel);
    }


}
