package controllers.Tasks;

import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;
import useCases.Tasks.RemoveTagInputBoundary;

/**
 * A controller which takes user input relevant to removing a Tag and sends it through the input boundary
 */
public class RemoveTagController {

    /**
     * The interface which allows access to the RemoveTag use case
     */
    private final RemoveTagInputBoundary inputBoundary;

    /**
     * Creates an instance of RemoveTagController with the required fields
     *
     * @param inputBoundary Interface for accessing the RemoveTag use case
     */
    public RemoveTagController(RemoveTagInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * The method which takes raw input pertaining to removing a Tag and returns a Response
     * This method packages the data into a TagRequestModel first before sending it through the input boundary
     *
     * @param name    The name of the Task
     * @param tagName The name of the Tag
     * @return The Response Model containing the name of the removed Tag
     */
    public TaskResponseModel removeTag(String name, String tagName) {
        TaskRequestModel taskRequestModel = new TaskRequestModel(
                name,
                null,
                null,
                null,
                tagName,
                null
        );
        return inputBoundary.removeTag(taskRequestModel);
    }

}
