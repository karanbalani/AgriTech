package com.example.kbala.agritech;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvMach;
    Button btnCoop , btnFarmer, btnRent ;
    FloatingActionButton fabCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMach = findViewById(R.id.tvMach);
        btnCoop = findViewById(R.id.btnCoop);
        btnFarmer = findViewById(R.id.btnFarmer);
        btnRent = findViewById(R.id.btnRent);
        fabCall = findViewById(R.id.fabCall);

        btnCoop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,CoopActivity.class);
                startActivity(i);


            }
            });

        btnFarmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,FarmersActivity.class);
                startActivity(i);
            }
        });

        btnRent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,RentActivity.class);
                startActivity(i);
            }
        });



    }
}
