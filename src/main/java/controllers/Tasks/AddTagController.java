package controllers.Tasks;

import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;
import useCases.Tasks.AddTagInputBoundary;

/**
 * A controller which takes user input relevant to adding a Tag to a task and sends it through the input boundary
 */
public class AddTagController {

    /**
     * The interface which allows access to the AddTag use case
     */
    private final AddTagInputBoundary inputBoundary;

    /**
     * Creates an instance of AddTagController with the required fields
     *
     * @param inputBoundary Interface for accessing the AddTag use case
     */
    public AddTagController(AddTagInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * The method which takes raw input pertaining to adding a Tag and returns a Response
     * This method packages the data into a TagRequestModel first before sending it through the input boundary
     *
     * @param name    The name of the Task
     * @param tagName The name of the Tag
     * @return The Response Model containing information about the Tag
     */
    public TaskResponseModel addTag(String name, String tagName) {
        TaskRequestModel taskRequestModel = new TaskRequestModel(
                name,
                null,
                null,
                null,
                tagName,
                null
        );
        return inputBoundary.addTag(taskRequestModel);
    }


}
