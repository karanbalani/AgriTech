package com.example.kbala.agritech;

import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kbala.agritech.interfaces.DialogCallback;
import com.example.kbala.agritech.utils.GlobalUtils;

import java.util.ArrayList;

public class FarmersActivity extends AppCompatActivity {

    Spinner spnFType,spnFDistrict;
    Button btnFarmerGetDetails,btnFarmerText,btnFarmerCall;
    TextView tvFarmerDistrict,tvFarmerMachine,tvFarmerGetDetails,tvVendorDetails;

    TextView tvResult = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmers);
        btnFarmerCall = findViewById(R.id.btnFarmerCall);
        tvResult = findViewById(R.id.tvResult);
        tvVendorDetails = findViewById(R.id.tvVendorDetails);
        tvFarmerDistrict = findViewById(R.id.tvFarmerDistrict);
        tvFarmerMachine = findViewById(R.id.tvFarmerMachine);
        tvFarmerGetDetails = findViewById(R.id.tvFarmerGetDetails);
        btnFarmerGetDetails = findViewById(R.id.btnFarmerGetDetails);
        btnFarmerText = findViewById(R.id.btnFarmerText);
        spnFDistrict = findViewById(R.id.spnFDistrict);
        spnFType = findViewById(R.id.spnFType);

        final ArrayList<String> s1 = new ArrayList<>();
        s1.add("Select Machine Type");
        s1.add("Happy Seeder");
        s1.add("Zero_till_drill");
        s1.add("Super Seeder");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,s1);

        spnFType.setAdapter(arrayAdapter);


        final ArrayList<String> s2 = new ArrayList<>();
        s2.add("Select District Name ");
        s2.add("Amritsar");
        s2.add("Mohali");
        s2.add("Patiala");
        s2.add("Jalandhar");
        s2.add("Ludhiana");


        ArrayAdapter arrayAdapter2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,s2);

        spnFDistrict.setAdapter(arrayAdapter2);

        btnFarmerGetDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id1 = spnFType.getSelectedItemPosition();
                String type = s1.get(id1);

                int id2 = spnFDistrict.getSelectedItemPosition();
                 String district = s2.get(id2);

                 String address = "";
                 String address2 = "";
                 String address3 = "";
                 String ratings = "";
                 String ratings2 = "";
                 String ratings3 = "";
                if(district.equals("Amritsar"))
                {
                    ratings = "3.0/5";
                    ratings2 = "2.0/5";
                    ratings3 = "1.0/5";
                    address = "Chohan Village , Jandiala-4 Tehsil , Amritsar District";
                    address2 = "Bhopta Village , Jandiala-6 Tehsil , Amritsar District";
                    address3 = "Arnala Village , Jandiala-8 Tehsil , Amritsar District";
                }
                else if(district.equals("Mohali"))
                {
                    ratings = "2.5/5";
                    ratings2= "4.0/5";
                    ratings3 = "2.0/5";
                    address = "Sahibzada Gurdas Singh Mohalla,Mohali, Punjab 160055";
                    address2 = "Sahibzada Rampur Kaur Road,Mohali, Punjab 160055";
                    address3 = "Sahibzada Village ,Mohali, Punjab 160055";
                }
                else if(district.equals("Jalandhar"))
                {
                    ratings = "4.0/5";
                    ratings2 = "1.0/5";
                    ratings3 = "4.5/5";
                    address = "Bajra Village , Jalandhar - West Tehsil , Jalandhar District";
                    address2 = "Jowar Village , Jalandhar - East Tehsil , Jalandhar District";
                    address3 = "Kheti Village , Jalandhar - Camp Tehsil , Jalandhar District";
                }
                else if(district.equals("Patiala"))
                {
                    ratings = "3.0/5";
                    ratings2 = "5.0/5";
                    ratings3 = "2.5/5";
                    address = "Barsat Village , Patiala Tehsil , Patiala District";
                    address2 = "Angaara Village , Patiala Tehsil , Patiala District";
                    address3 = "Govandi Village , Patiala Tehsil , Patiala District";
                }
                else if (district.equals("Ludhiana"))
                {
                    ratings = "3.5/5";
                    ratings = "1.0/5";
                    ratings = "2.0/5";
                    address = "Allowal Village, Ludhiana Tehsil, Ludhiana District";
                    address2 = "Chauraha Village, Ludhiana Tehsil, Ludhiana District";
                    address3 = "Galilok Village, Ludhiana Tehsil, Ludhiana District";
                }

                String price="";
                String price2="";
                String price3="";

                if((district.equals("Amritsar"))) {price = "Rs.2000";
                price2 = "Rs. 1800";
                price3 = "Rs. 2100";
                }
                else if (district.equals("Mohali")) {
                    price = "Rs. 1900";
                    price2 = "Rs. 1750";
                    price3 = "Rs. 2050";
                }
                else if (district.equals("Jalandhar")){price = "Rs. 1900";
                    price2 = "Rs. 1750";
                    price3 = "Rs. 2050";
            }
                else if (district.equals("Patiala")) {price = "Rs. 1900";
                    price2 = "Rs. 1750";
                    price3 = "Rs. 2050";
            }
                else if (district.equals("Ludhiana")){ price = "Rs. 1900";
                    price2 = "Rs. 1750";
                    price3 = "Rs. 2050";
                }


                String msg = "Type of Machine : " + type + "\n" + "District : " + district +
                        "\n\n " + "Lenders closest to you : " + "\n\n\n1) Address :" + address + "\n " + " Ratings : " + ratings + "\n " + "Price :" + price
                        + "\n\n\n2) Address : " + address2 + "\n" + " Ratings :  " + ratings2 + "\n" + "Price :" + price2
                        + "\n\n\n3) Address : " + address3 + "\n" + " Ratings :  " + ratings3 + "\n" + "Price :" + price3;

                tvFarmerGetDetails.setText(msg);
                String vendor = "Name : Agro Industries " + "\n" + "Address : Agro Industries, off NH7 \n Pathankot District, Punjab " + "\nContact : 9769057673";
                tvVendorDetails.setText(vendor);
                
            }
        });

        btnFarmerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int id1 = spnFType.getSelectedItemPosition();
                String type = s1.get(id1);
                int id2 = spnFDistrict.getSelectedItemPosition();
                String district = s2.get(id2);
                String price="";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("sms:"+ "9769057673"));
                i.putExtra("sms_body","I wanted to request you to lend me the following machine : " + type);
                startActivity(i);
            }
        });

        btnFarmerCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(Intent.ACTION_DIAL);
                i2.setData(Uri.parse("tel:" + "9769057673"));
                startActivity(i2);
            }
        });

    }

    public void showDialog(View view)
    {
        GlobalUtils.showDialog(this, new DialogCallback() {
            @Override
            public void callback(String ratings) {
                Toast.makeText(FarmersActivity.this, "THANKYOU for the feedback ! ", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
