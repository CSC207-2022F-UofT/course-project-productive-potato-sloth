package controllers.Tasks;

import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;
import useCases.Tasks.EditTaskInputBoundary;

/**
 * A controller which takes user input relevant to editing a Task name and sends it through the input boundary
 */
public class EditTaskNameController {

    /**
     * The interface which allows access to the EditTask use case
     */
    private final EditTaskInputBoundary inputBoundary;

    /**
     * Creates an instance of EditTaskNameController with the required fields
     *
     * @param inputBoundary Interface for accessing the EditTaskName use case
     */
    public EditTaskNameController(EditTaskInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * The method which takes raw input pertaining to editing the name of Task and returns a Response
     * This method packages the data into a TaskRequestModel first before sending it through the input boundary
     *
     * @param name    The name of the Task
     * @param newName The new name of the Task
     * @return The Response Model containing the new name
     */
    public TaskResponseModel editName(String name, String newName) {
        TaskRequestModel taskRequestModel = new TaskRequestModel(
                name,
                newName,
                null,
                null,
                null,
                null
        );
        return inputBoundary.editName(taskRequestModel);
    }

}
