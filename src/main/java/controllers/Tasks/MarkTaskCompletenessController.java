package controllers.Tasks;

import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;
import useCases.Tasks.MarkTaskCompletenessInputBoundary;

/**
 * A controller which takes user input relevant to Task completeness and sends it through the input boundary
 */
public class MarkTaskCompletenessController {

    /**
     * The interface which allows access to the MarkTaskCompleteness use case
     */
    private final MarkTaskCompletenessInputBoundary inputBoundary;

    /**
     * Creates an instance of MarkTaskCompleteness with the required fields
     *
     * @param inputBoundary Interface for accessing the MarkTaskCompleteness use case
     */
    public MarkTaskCompletenessController(MarkTaskCompletenessInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * The method which takes raw input pertaining to the completeness of a Task and returns a Response
     * This method packages the data into a TaskRequestModel first before sending it through the input boundary
     *
     * @param name      The name of the Task
     * @param completed The completeness of the Task
     * @return The Response Model containing the new completeness of the Task
     */
    public TaskResponseModel setCompleteness(String name, Boolean completed) {
        TaskRequestModel taskRequestModel = new TaskRequestModel(
                name,
                null,
                null,
                completed,
                null,
                null
        );
        return inputBoundary.setCompleteness(taskRequestModel);
    }


}
