package presenters;

import gateways.Tasks.TaskInfoRequestModel;
import gateways.Tasks.TaskInfoResponseModel;
import screens.TaskList.TaskError;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TaskInfoResponseFormatter implements TaskInfoPresenter {
    @Override
    public TaskInfoResponseModel prepareSuccessView(TaskInfoResponseModel taskInfoResponseModel) {

//        if (taskInfoResponseModel.getTags().size() == 0) {
//            ArrayList<String> tags = new ArrayList<>();
//            tags.add(" ");
//            taskInfoResponseModel.setTags(tags);
//        }

        return taskInfoResponseModel;
    }

    @Override
    public TaskInfoResponseModel prepareFailView(String error) {
        throw new TaskError(error);
    }
}
