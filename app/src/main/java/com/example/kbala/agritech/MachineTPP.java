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

public class MachineTPP extends AppCompatActivity {
    TextView tvTAgri,tvTDistrict,tvTGetDetails;
    Button btnTGetDetails;
    Spinner spnTType,spnTDistrict;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_machine_tpp);

        tvTAgri = findViewById(R.id.tvTAgri);
        tvTDistrict = findViewById(R.id.tvTDistrict);
        btnTGetDetails = findViewById(R.id.btnTGetDetails);
        spnTType = findViewById(R.id.spnTType);
        spnTDistrict = findViewById(R.id.spnTDistrict);

        final ArrayList<String> s1 = new ArrayList<>();
        s1.add("Select Machine Type");
        s1.add("Happy Seeder");
        s1.add("Zero_till_drill");
        s1.add("Super Seeder");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,s1);

        spnTType.setAdapter(arrayAdapter);


        final ArrayList<String> s2 = new ArrayList<>();
        s2.add("Select District Name ");
        s2.add("Amritsar");
        s2.add("Mohali");
        s2.add("Patiala");
        s2.add("Jalandhar");
        s2.add("Ludhiana");


        ArrayAdapter arrayAdapter2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,s2);

        spnTDistrict.setAdapter(arrayAdapter2);



        btnTGetDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int id1 = spnTType.getSelectedItemPosition();
                String type = s1.get(id1);

                int id2 = spnTDistrict.getSelectedItemPosition();
                String district = s2.get(id2);

                String address = "";
                String address2 = "";
                String address3 = "";

                String name1 = "";
                String name2 = "";
                String name3 = "";

                if(district.equals("Amritsar"))
                {
                    name1 = "Jasvinder Kaur";
                    name2 = "Joginder Sharma";
                    name3 = "Gurpreet Singh";
                    address = "Chohan Village , Jandiala-4 Tehsil , Amritsar District";
                    address2 = "Bhopta Village , Jandiala-6 Tehsil , Amritsar District";
                    address3 = "Arnala Village , Jandiala-8 Tehsil , Amritsar District";
                }
                else if(district.equals("Mohali"))
                {
                    name1 = "Manpreet Kaur";
                    name2 = "Diljit Sharma";
                    name3 = "Ramdas Singh";
                    address = "Sahibzada Gurdas Singh Mohalla,Mohali, Punjab 160055";
                    address2 = "Sahibzada Rampur Kaur Road,Mohali, Punjab 160055";
                    address3 = "Sahibzada Village ,Mohali, Punjab 160055";
                }
                else if(district.equals("Jalandhar"))
                {
                    name1 = "Rajjo Kaur";
                    name2 = "Rajesh Sharma";
                    name3 = "Veere Singh";
                    address = "Bajra Village , Jalandhar - West Tehsil , Jalandhar District";
                    address2 = "Jowar Village , Jalandhar - East Tehsil , Jalandhar District";
                    address3 = "Kheti Village , Jalandhar - Camp Tehsil , Jalandhar District";
                }
                else if(district.equals("Patiala"))
                {
                    name1 = "Preet Kaur";
                    name2 = "Balwinder Sharma";
                    name3 = "Sethji Singh";
                    address = "Barsat Village , Patiala Tehsil , Patiala District";
                    address2 = "Angaara Village , Patiala Tehsil , Patiala District";
                    address3 = "Govandi Village , Patiala Tehsil , Patiala District";
                }
                else if (district.equals("Ludhiana"))
                {
                    name1 = "Jasu Kaur";
                    name2 = "Haswinder Sharma";
                    name3 = "Rajpal Singh";
                    address = "Allowal Village, Ludhiana Tehsil, Ludhiana District";
                    address2 = "Chauraha Village, Ludhiana Tehsil, Ludhiana District";
                    address3 = "Galilok Village, Ludhiana Tehsil, Ludhiana District";
                }

                String phone="";
                String phone2 = "";
                String phone3 = "";
                if((district.equals("Amritsar")))
                {
                    phone = "08427726529";
                    phone2 = "5465467568";
                    phone3 = "4556789876";
                }
                else if (district.equals("Mohali")) {
                    phone = "08427726529";
                    phone2 = "5465467568";
                    phone3 = "4556789876";
                }
                else if (district.equals("Jalandhar")){
                    phone = "08427726529";
                    phone2 = "5465467568";
                    phone3 = "4556789876";
                }
                else if (district.equals("Patiala")) {
                    phone = "08427726529";
                    phone2 = "5465467568";
                    phone3 = "4556789876";
                }
                else if (district.equals("Ludhiana")) {
                    phone = "08427726529";
                    phone2 = "5465467568";
                    phone3 = "4556789876";
                }



                String msg = "Type of Machine : " + type + "\n" + "District : " + district +
                        "\n\n " + "Lenders Available: " ;

                String msg1 = "1) Name : " + name1 + "\n Address :" + address;
                String msg2 = "2) Name : " + name2 + "\nAddress : " + address2;
                String msg3 = "3) Name : " + name3 + "\nAddress : " + address3;


                Intent i = new Intent(MachineTPP.this,TPPLenderslist.class);
                i.putExtra("phone",phone);
                i.putExtra("phone2",phone2);
                i.putExtra("phone3",phone3);
                i.putExtra("msg",msg);
                i.putExtra("msg1",msg1);
                i.putExtra("msg2",msg2);
                i.putExtra("msg3",msg3);
                startActivity(i);

            }
        });

    }

}
