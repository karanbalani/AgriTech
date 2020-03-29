package com.example.kbala.agritech;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserTypeActivity extends AppCompatActivity {


    Button btnUserFarmer,btnUserTPP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_type);
        btnUserFarmer = findViewById(R.id.btnUserFarmer);
        btnUserTPP = findViewById(R.id.btnUserTPP);

        btnUserFarmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(UserTypeActivity.this,FeaturesActivity.class);
                startActivity(i);
            }
        });

        btnUserTPP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(UserTypeActivity.this,MachineTPP.class);
                startActivity(i);
            }
        });
    }
}
