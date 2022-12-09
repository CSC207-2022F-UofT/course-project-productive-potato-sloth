package controllers.Tasks;

import gateways.Tasks.TaskInfoRequestModel;
import gateways.Tasks.TaskInfoResponseModel;
import useCases.Tasks.GetTaskInfoInputBoundary;

/**
 * A controller which takes user input relevant to retrieving Task info and sends it through the input boundary
 */
public class GetTaskInfoController {

    /**
     * The interface which allows access to the GetTaskInfo use case
     */
    private final GetTaskInfoInputBoundary inputBoundary;

    /**
     * Creates an instance of GetTaskInfoController with the required fields
     *
     * @param inputBoundary Interface for accessing the GetTaskInfo use case
     */
    public GetTaskInfoController(GetTaskInfoInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * The method which a name of an existing Task and returns a Response
     * This method packages the data into a TaskRequestModel first before sending it through the input boundary
     *
     * @param name The name of the Task
     * @return The Response Model containing all fields of the Task
     */
    public TaskInfoResponseModel getInfo(String name) {
        TaskInfoRequestModel taskRequestModel = new TaskInfoRequestModel(name);
        return inputBoundary.getInfo(taskRequestModel);
    }

}
