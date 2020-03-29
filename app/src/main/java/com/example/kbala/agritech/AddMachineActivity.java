package com.example.kbala.agritech;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddMachineActivity extends AppCompatActivity {
    EditText etAddType,etAddDistrict;
    Button btnAddSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_machine);

        etAddType = findViewById(R.id.etAddType);
        etAddDistrict = findViewById(R.id.etAddDistrict);
        btnAddSave = findViewById(R.id.btnAddSave);

        btnAddSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String type = etAddType.getText().toString();
                if(type.length()==0)
                {
                    etAddType.setError("Machine column empty");
                    etAddType.requestFocus();
                    return;
                }

                String district = etAddDistrict.getText().toString();
                if(district.length()==0)
                {
                    etAddDistrict.setError("District column empty");
                    etAddDistrict.requestFocus();
                    return;
                }
                Machine m = new Machine(type,district);
                RentActivity.db.addMachine(m);
                etAddDistrict.setText("");
                etAddType.setText("");
                etAddType.requestFocus();
            }
        });
    }
}