package com.dsk.layoutdesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PaymentActivity extends AppCompatActivity {

    private PackDetails details;
    private ExpandableListView expandable_list1;
    private ExpandableListView expandable_list2;

    private ImageButton back_button;

    private TextView price;
    private Button pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        init();

        back_button.setOnClickListener(view -> {
            finish();
        });

        List<String> groupTitles1 = new ArrayList<>();
        groupTitles1.add("UPI");

        HashMap<String, List<String>> childData1 = new HashMap<>();

        List<String> childData1Items = new ArrayList<>();
        childData1Items.add("Google Pay");
        /*childData1Items.add("Paytm");
        childData1Items.add("Phone Pay");*/

        childData1.put("UPI", childData1Items);


        List<String> groupTitles2 = new ArrayList<>();
        groupTitles2.add("CREDIT/DEBIT/ATM CARD");

        HashMap<String, List<String>> childData2 = new HashMap<>();

        List<String> childData2Items = new ArrayList<>();
        childData2Items.add("");

        childData2.put("CREDIT/DEBIT/ATM CARD", childData2Items);

        ExpandableListData data1 = new ExpandableListData(groupTitles1, childData1);
        ExpandableListData data2 = new ExpandableListData(groupTitles2, childData2);

        ExpandableListAdapter1 adapter1 = new ExpandableListAdapter1(this, data1);
        expandable_list1.setAdapter(adapter1);

        ExpandableListAdapter2 adapter2 = new ExpandableListAdapter2(this, data2);
        expandable_list2.setAdapter(adapter2);

        expandable_list1.expandGroup(0);
        expandable_list1.setGroupIndicator(AppCompatResources.getDrawable(PaymentActivity.this, R.drawable.arrow_up));
        expandable_list1.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                if (expandableListView.isGroupExpanded(0))
                    expandable_list1.setGroupIndicator(AppCompatResources.getDrawable(PaymentActivity.this, R.drawable.arrow_down));
                else
                    expandable_list1.setGroupIndicator(AppCompatResources.getDrawable(PaymentActivity.this, R.drawable.arrow_up));

                return false;
            }
        });


        expandable_list2.setGroupIndicator(AppCompatResources.getDrawable(PaymentActivity.this, R.drawable.arrow_down));
        expandable_list2.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                if (expandableListView.isGroupExpanded(0))
                    expandable_list2.setGroupIndicator(AppCompatResources.getDrawable(PaymentActivity.this, R.drawable.arrow_down));
                else
                    expandable_list2.setGroupIndicator(AppCompatResources.getDrawable(PaymentActivity.this, R.drawable.arrow_up));

                return false;
            }
        });

        pay.setOnClickListener(view -> {
            Toast.makeText(this, adapter1.getSelected() + " is selected", Toast.LENGTH_SHORT).show();
        });

    }

    void init() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setTitle("");

        Intent intent = getIntent();
        details = intent.getParcelableExtra("packDetails");

        expandable_list1 = findViewById(R.id.expandable_list1);
        expandable_list2 = findViewById(R.id.expandable_list2);

        back_button = findViewById(R.id.backButton);
        price = findViewById(R.id.price);
        pay = findViewById(R.id.pay);

        price.setText(details.getPrice());

    }
}