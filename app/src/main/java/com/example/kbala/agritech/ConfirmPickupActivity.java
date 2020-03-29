package com.example.kbala.agritech;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmPickupActivity extends AppCompatActivity {

    TextView tvPickupDetails;
    Button btnCallPickup,btnTextPickup,btnProceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_pickup);
        tvPickupDetails = findViewById(R.id.tvPickupDetails);
        btnProceed = findViewById(R.id.btnProceed);
        btnCallPickup = findViewById(R.id.btnCallPickup);
        btnTextPickup = findViewById(R.id.btnTextPickup);


        Intent i = getIntent();
        final String msg = i.getStringExtra("msg");
        final String weight = i.getStringExtra("weight");
        final String grains = i.getStringExtra("grains");

        btnCallPickup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(Intent.ACTION_DIAL);
                i2.setData(Uri.parse("tel:" + "9769057672"));
                startActivity(i2);
            }
        });

        btnTextPickup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("sms:"+ ""));
                i.putExtra("sms_body","I wanted to request for pickup of stubble which is approximately "
                        + weight +  " and consists of :  " + "following grains : " + grains + "My details are : " + msg );
                startActivity(i);
            }
        });

        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ConfirmPickupActivity.this,GuidelinesFinal.class);
                startActivity(i);

            }
        });

    }
}
