package com.example.kbala.agritech;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TPPLenderslist extends AppCompatActivity {

    TextView tvLenders,tvLender1,tvLender2,tvLender3;
    Button btnLenderCall1,btnLenderCall2,btnLenderCall3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tpplenderslist);
        tvLenders = findViewById(R.id.tvLenders);
        tvLender1 = findViewById(R.id.tvLender1);
        tvLender2 = findViewById(R.id.tvLender2);
        tvLender3 = findViewById(R.id.tvLender3);
        btnLenderCall1 = findViewById(R.id.btnLenderCall1);
        btnLenderCall2 = findViewById(R.id.btnLenderCall2);
        btnLenderCall3 = findViewById(R.id.btnLenderCall3);


        Intent i = getIntent();
        final String msg = i.getStringExtra("msg");
        final String msg1 = i.getStringExtra("msg1");
        final String msg2 = i.getStringExtra("msg2");
        final String msg3 = i.getStringExtra("msg3");
        final String phone = i.getStringExtra("phone");
        final String phone2 = i.getStringExtra("phone2");
        final String phone3 = i.getStringExtra("phone3");

        tvLenders.setText(msg);
        tvLender1.setText(msg1);
        tvLender2.setText(msg2);
        tvLender3.setText(msg3);

        btnLenderCall1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(Intent.ACTION_DIAL);
                i2.setData(Uri.parse("tel:" + phone));
                startActivity(i2);
            }
        });

        btnLenderCall2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(Intent.ACTION_DIAL);
                i2.setData(Uri.parse("tel:" + phone2));
                startActivity(i2);
            }
        });

        btnLenderCall3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(Intent.ACTION_DIAL);
                i2.setData(Uri.parse("tel:" + phone3));
                startActivity(i2);
            }
        });
    }
}
