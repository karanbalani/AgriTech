package com.example.kbala.agritech;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CoopGetDetails extends AppCompatActivity {

    Button btnCoopCall;
    TextView tvGetDetails,tvGetAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coop_get_details);
        tvGetAddress = findViewById(R.id.tvGetAddress);
        tvGetDetails = findViewById(R.id.tvGetDetails);
        btnCoopCall = findViewById(R.id.btnCoopCall);
        Intent i = getIntent();
        final String msg = i.getStringExtra("msg");
        final String address = i.getStringExtra("address");
        final String phone = i.getStringExtra("phone");

        tvGetDetails.setText(msg);
        tvGetAddress.setText(address);

        btnCoopCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(Intent.ACTION_DIAL);
                i2.setData(Uri.parse("tel:" + phone));
                startActivity(i2);
            }
        });





    }
}
