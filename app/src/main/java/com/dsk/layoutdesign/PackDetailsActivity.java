package com.dsk.layoutdesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class PackDetailsActivity extends AppCompatActivity {

    private PackDetails details;
    private TextView price;
    private TextView feature1;
    private TextView feature2;
    private TextView feature3;
    //private TextView sms;
    private Button buy;
    private ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pack_details);

        setTitle("");
        setStatusBarColor("#EEF0FD");
        initialize();

        price.setText(details.getPrice());
        feature1.setText(details.getFeature1());
        feature2.setText(details.getFeature2());
        feature3.setText(details.getFeature3());
        //sms.setText(details.getSms());

        buy.setOnClickListener(view -> {
            Toast.makeText(this, "Buy Button clicked", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, PaymentActivity.class);
            intent.putExtra("packDetails", details);
            startActivity(intent);
        });

        back.setOnClickListener(view -> {
            finish();
        });
    }

    private void initialize() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        details = intent.getParcelableExtra("packDetails");

        price = findViewById(R.id.price);
        feature1 = findViewById(R.id.feature1);
        feature2 = findViewById(R.id.feature2);
        feature3 = findViewById(R.id.feature3);
        //sms = findViewById(R.id.sms);
        buy = findViewById(R.id.buy);
        back = findViewById(R.id.backButton);
    }

    private void setStatusBarColor(String colorHex) {
        Window window = getWindow();

        // Check if the Android version is Lollipop or higher
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(android.graphics.Color.parseColor(colorHex));
    }
}
