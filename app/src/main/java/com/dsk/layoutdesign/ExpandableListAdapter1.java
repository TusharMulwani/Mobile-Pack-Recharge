package com.dsk.layoutdesign;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

public class ExpandableListAdapter1 extends BaseExpandableListAdapter {

    private final Context context;
    private final ExpandableListData data;

    private RadioButton gpay = null;
    private RadioButton paytm = null;
    private RadioButton phonePay = null;

    public String getSelected() {
        return selected;
    }

    private String selected = "";

    public ExpandableListAdapter1(Context context, ExpandableListData data) {
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
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.radio_buttons_list_item, null);
        }

        Log.e("adapter", "text " + childText);

        gpay = convertView.findViewById(R.id.gpay_radio_button);
        gpay.setOnClickListener(view -> {
            selected = "Google Pay";

            if (gpay.isSelected())
                gpay.setSelected(false);
        });

        paytm = convertView.findViewById(R.id.paytm_radio_button);
        paytm.setOnClickListener(view -> {
            selected = "Paytm";

            if (paytm.isSelected())
                paytm.setSelected(false);
        });

        phonePay = convertView.findViewById(R.id.phonePay_radio_button);
        phonePay.setVisibility(View.VISIBLE);
        phonePay.setOnClickListener(view -> {

            selected = "Phone Pay";

            if (phonePay.isSelected())
                phonePay.setSelected(false);
        });

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
