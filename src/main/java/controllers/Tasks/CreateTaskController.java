package controllers.Tasks;

import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;
import useCases.Tasks.AddTagInputBoundary;
import useCases.Tasks.CreateTaskInputBoundary;

/**
 * A controller which takes user input relevant to creating a Task and sends it through the input boundary
 */
public class CreateTaskController {

    /**
     * The interface which allows access to the CreateTask use case
     */
    private final CreateTaskInputBoundary inputBoundary;

    /**
     * Creates an instance of CreateTaskController with the required fields
     *
     * @param inputBoundary Interface for accessing the CreateTask use case
     */
    public CreateTaskController(CreateTaskInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * The method which takes raw input pertaining to creating a Task and returns a Response
     * This method packages the data into a TaskRequestModel first before sending it through the input boundary
     *
     * @param name The name of the Task
     * @return The Response Model containing the information about the Task
     */
    public TaskResponseModel createTask(String name) {
        TaskRequestModel taskRequestModel = new TaskRequestModel(
                name,
                null,
                null,
                null,
                null,
                null
        );
        return inputBoundary.create(taskRequestModel);
    }

}
