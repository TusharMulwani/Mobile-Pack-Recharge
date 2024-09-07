package com.dsk.layoutdesign;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ExpandableListAdapter2 extends BaseExpandableListAdapter {

    private final Context context;
    private final ExpandableListData data;

    public ExpandableListAdapter2(Context context, ExpandableListData data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getGroupCount() {
        return data.getGroupTitles().size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return data.getChildData().get(data.getGroupTitles().get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return data.getGroupTitles().get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return data.getChildData().get(data.getGroupTitles().get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String groupTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_group, null);
        }

        TextView groupTextView = convertView.findViewById(R.id.list_group_title);
        groupTextView.setText(groupTitle);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String childText = (String) getChild(groupPosition, childPosition);
        String groupText = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.card_details_list_item, null);
        }

        EditText cardNumber = convertView.findViewById(R.id.card_number);
        cardNumber.setVisibility(View.VISIBLE);
        LinearLayout cardDetails = convertView.findViewById(R.id.card_details);
        cardDetails.setVisibility(View.VISIBLE);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
