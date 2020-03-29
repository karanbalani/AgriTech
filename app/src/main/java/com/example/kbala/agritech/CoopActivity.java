package com.example.kbala.agritech;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class CoopActivity extends AppCompatActivity {


    TextView tvAgri,tvDistrict,tvGetDetails;
    Button btnCoopGetDetails;
    Spinner spnType,spnDistrict;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coop);

        tvAgri = findViewById(R.id.tvAgri);
        tvGetDetails = findViewById(R.id.tvGetDetails);
        tvDistrict = findViewById(R.id.tvDistrict);
        btnCoopGetDetails = findViewById(R.id.btnCoopGetDetails);
        spnType = findViewById(R.id.spnType);
        spnDistrict = findViewById(R.id.spnDistrict);

        final ArrayList<String> s1 = new ArrayList<>();
        s1.add("Select Machine Type");
        s1.add("Happy Seeder");
        s1.add("Zero_till_drill");
        s1.add("Super Seeder");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,s1);

        spnType.setAdapter(arrayAdapter);


        final ArrayList<String> s2 = new ArrayList<>();
        s2.add("Select District Name ");
        s2.add("Amritsar");
        s2.add("Mohali");
        s2.add("Patiala");
        s2.add("Jalandhar");
        s2.add("Ludhiana");


        ArrayAdapter arrayAdapter2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,s2);

        spnDistrict.setAdapter(arrayAdapter2);


        btnCoopGetDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int id1 = spnType.getSelectedItemPosition();
                String type = s1.get(id1);

                int id2 = spnDistrict.getSelectedItemPosition();
                String district = s2.get(id2);


                String address = "";
                if(district.equals("Amritsar"))
                {
                    address = "Kamboj Mech Works\n" +
                            "V.P.O. Ramdas, Teh. Ajnala, \n" +
                            "Amritsar-143603,Punjab,India\n" +
                            "Contact - 08427726529";
                }
                else if(district.equals("Mohali"))
                {
                    address = "Jai Baba Vishavkarma Agro Industries\n" +
                            "Plot No. F-324, Phase 8 B,\n" +
                            "Mohali-160071, Punjab,India\n" +
                            "Contact - 08046049134";
                }
                else if(district.equals("Jalandhar"))
                {
                    address = "Amar Agritech\n" +
                            "Gaushala Road, Near Transport Nagar,, Bulandpur Village,\n" +
                            "Jalandhar-144008, Punjab, India\n" +
                            "Contact - 8437037043";
                }
                else if(district.equals("Patiala"))
                {
                    address = "\n" +
                            "Azad Metals Pvt Ltd\n" +
                            "Narwana Road, Hamjheri Byepass, Patran,\n" +
                            "Patiala-147105, Punjab,India\n" +
                            "Contact - 9781984888";
                }
                else if (district.equals("Ludhiana"))
                {
                    address = "National Agro Industries\n" +
                            "Opp., 1-A, Link Rd,\n" +
                            "Transport Nagar, Industrial Area- A,\n" +
                            "Ludhiana-141003, Punjab,India\n" +
                            "Contact - 01612222041 ";
                }

                String msg = "Type of Machine : " + type + "\n" + "District : " + district ;

                String phone="";

                if((district.equals("Amritsar"))) phone = "08427726529";
                else if (district.equals("Mohali")) phone = "08046049134";
                else if (district.equals("Jalandhar")) phone = "8437037043";
                else if (district.equals("Patiala")) phone = "9781984888";
                else if (district.equals("Ludhiana")) phone = "01612222041";

                Intent i = new Intent(CoopActivity.this,CoopGetDetails.class);
                i.putExtra("msg",msg);
                i.putExtra("address",address);
                i.putExtra("phone",phone);
                startActivity(i);


            }
        });

    }
}
