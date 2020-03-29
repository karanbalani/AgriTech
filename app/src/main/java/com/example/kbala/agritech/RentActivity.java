package com.example.kbala.agritech;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RentActivity extends AppCompatActivity {
    Button btnAddMac,btnViewMac,btnDelMac;
    static DBHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent);

        btnAddMac = findViewById(R.id.btnAddMac);
        btnViewMac = findViewById(R.id.btnViewMac);
        btnDelMac = findViewById(R.id.btnDelMac);
        db = new DBHandler(this);

        btnAddMac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RentActivity.this,AddMachineActivity.class));
            }
        });

        btnViewMac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RentActivity.this,ViewMachineActivity.class));
            }
        });

        btnDelMac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RentActivity.this,DeleteMachineActivity.class));
            }
        });
    }
}
