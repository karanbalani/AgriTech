package com.example.kbala.agritech;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewMachineActivity extends AppCompatActivity {

    TextView tvData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_machine);

        tvData = findViewById(R.id.tvData);
        String data = RentActivity.db.viewMachine();

        if(data.length() == 0)
            tvData.setText("No Records Found");
        else
            tvData.setText(data);
    }
}
