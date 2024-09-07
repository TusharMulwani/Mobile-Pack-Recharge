package com.dsk.layoutdesign;

import java.util.HashMap;
import java.util.List;

public class ExpandableListData {

    private final List<String> groupTitles;
    private final HashMap<String, List<String>> childData;

    public ExpandableListData(List<String> groupTitles, HashMap<String, List<String>> childData) {
        this.groupTitles = groupTitles;
        this.childData = childData;
    }

    public List<String> getGroupTitles() {
        return groupTitles;
    }

    public HashMap<String, List<String>> getChildData() {
        return childData;
    }
}
