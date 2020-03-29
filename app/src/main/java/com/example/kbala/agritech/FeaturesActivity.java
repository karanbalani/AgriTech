package com.example.kbala.agritech;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FeaturesActivity extends AppCompatActivity {
    Button btnAcquire,btnPickup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_features);
        btnAcquire = findViewById(R.id.btnAcquire);
        btnPickup = findViewById(R.id.btnPickup);

        btnAcquire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FeaturesActivity.this,MainActivity.class);
                startActivity(i);
            }
        });

        btnPickup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FeaturesActivity.this,PickupActivity.class);
                startActivity(i);
            }
        });
    }
}
