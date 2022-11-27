package screens.ScheduleEvent;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class ScheduleEventViewModel {
    private final List<String> task_names;
    private final List<String> tag_names;

    public ScheduleEventViewModel(){
        this.task_names = new ArrayList<>();
        this.tag_names = new ArrayList<>();
    }

    public void addTaskName(String taskName){
        task_names.add(taskName);
    }

    public void addTagName(String tagName){
        tag_names.add(tagName);
    }

    public String[] getTaskNamesArray(){
        String[] taskNamesArray = new String[this.task_names.size()];
        return task_names.toArray(taskNamesArray);
    }

    public String[] getTagNamesArray(){
        String[] tagNamesArray = new String[this.tag_names.size()];
        return tag_names.toArray(tagNamesArray);
    }
}
