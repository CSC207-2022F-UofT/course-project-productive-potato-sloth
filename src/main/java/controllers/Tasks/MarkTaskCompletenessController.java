package controllers.Tasks;

import gateways.Tasks.TaskRequestModel;
import gateways.Tasks.TaskResponseModel;
import useCases.Tasks.MarkTaskCompletenessInputBoundary;

public class MarkTaskCompletenessController {

    private final MarkTaskCompletenessInputBoundary inputBoundary;

    public MarkTaskCompletenessController(MarkTaskCompletenessInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

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
