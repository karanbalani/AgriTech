package com.example.kbala.agritech;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DeleteMachineActivity extends AppCompatActivity {
    EditText etDeleteType;
    Button btnDelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_machine);

        etDeleteType = findViewById(R.id.etDeleteType);
        btnDelete = findViewById(R.id.btnDelete);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String type = etDeleteType.getText().toString();
                if (type.length()==0)
                {
                    etDeleteType.setError("Machine column is empty");
                    etDeleteType.requestFocus();
                    return;
                }

                Machine m = new Machine(type,"");
                RentActivity.db.deleteMachine(m);
                etDeleteType.setText("");
                etDeleteType.requestFocus();
            }
        });
    }
}
