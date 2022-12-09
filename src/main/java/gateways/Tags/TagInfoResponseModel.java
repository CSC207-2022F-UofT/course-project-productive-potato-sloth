package gateways.Tags;

import java.util.ArrayList;
import java.util.List;

public class TagInfoResponseModel {
    final List<String> tagList = new ArrayList<>();

    public void addTag(String tag) {
        tagList.add(tag);
    }

    public List<String> getTags() {
        return tagList;
    }

}
