package com.example.kbala.agritech;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PickupActivity extends AppCompatActivity {

    EditText etFarmerName,etFarmerPhone,etWeightStub;
    Button btnPickupNext;
    TextView tvStubbleInfo;
    CheckBox cbWheat,cbRice,cbSugarCane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pickup);
        etFarmerName = findViewById(R.id.etFarmerName);
        etFarmerPhone = findViewById(R.id.etFarmerPhone);
        etWeightStub = findViewById(R.id.etWeightStub);
        btnPickupNext = findViewById(R.id.btnPickupNext);
        tvStubbleInfo = findViewById(R.id.tvStubbleInfo);
        cbWheat = findViewById(R.id.cbWheat);
        cbRice = findViewById(R.id.cbRice);
        cbSugarCane = findViewById(R.id.cbSugarCane);

        btnPickupNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etFarmerName.getText().toString();
                if(name.length()==0)
                {
                    etFarmerName.setError("Please Enter Name");
                    etFarmerName.requestFocus();
                    return;
                }

                String phone = etFarmerPhone.getText().toString();
                if(phone.length()==0)
                {
                    etFarmerPhone.setError("District column empty");
                    etFarmerPhone.requestFocus();
                    return;
                }

                String msg = "Name : " + name + "\n" + "Phone number : " + phone ;
                String weight =  "Weight : " + etWeightStub.getText().toString();

                String grains = "";

                if(cbRice.isChecked())
                    grains = grains + " Rice ";
                if(cbWheat.isChecked())
                    grains = grains + " Wheat ";
                if(cbSugarCane.isChecked())
                    grains = grains + " Sugarcane ";

                if(!cbSugarCane.isChecked() & !cbWheat.isChecked() & !cbRice.isChecked())
                {
                    Toast.makeText(PickupActivity.this, "Select atleast one to proceed", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    Intent i = new Intent(PickupActivity.this,ConfirmPickupActivity.class);
                    i.putExtra("msg",msg);
                    i.putExtra("weight",weight);
                    i.putExtra("grains",grains);
                    startActivity(i);

                }
            }


        });



    }
}
