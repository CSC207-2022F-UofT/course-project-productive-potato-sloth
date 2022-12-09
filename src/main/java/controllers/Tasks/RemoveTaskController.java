package controllers.Tasks;

import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;
import useCases.Tasks.RemoveTaskInputBoundary;

/**
 * A controller which takes user input relevant to removing a Task and sends it through the input boundary
 */
public class RemoveTaskController {

    /**
     * The interface which allows access to the RemoveTask use case
     */
    private final RemoveTaskInputBoundary inputBoundary;

    /**
     * Creates an instance of RemoveTaskController with the required fields
     *
     * @param inputBoundary Interface for accessing the RemoveTask use case
     */
    public RemoveTaskController(RemoveTaskInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * The method which takes raw input pertaining to removing a Task and returns a Response
     * This method packages the data into a TaskRequestModel first before sending it through the input boundary
     *
     * @param name The name of the Task
     * @return The Response Model containing the name of the removed Task
     */
    public TaskResponseModel removeTask(String name) {
        TaskRequestModel taskRequestModel = new TaskRequestModel(
                name,
                null,
                null,
                null,
                null,
                null
        );
        return inputBoundary.removeTask(taskRequestModel);
    }

}
