package gateways.Tags;

import entities.Tag;

import java.util.ArrayList;
import java.util.List;

public class TagInfoResponseModel {
    List<String> tagList = new ArrayList<>();

    public void addTag(String tag) {
        tagList.add(tag);
    }

    public List<String> getTags() {
        return tagList;
    }

}
