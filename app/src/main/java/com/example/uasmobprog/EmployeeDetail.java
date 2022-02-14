package com.example.uasmobprog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class EmployeeDetail extends AppCompatActivity  {
    TextView text1, text2, text3, text4, text5;
    String first,last,city,country,phone,cell,latitude,longitude,email,member,picture;
    private Button addBtn;
    public static ArrayList<AddressDetail> address = new ArrayList<>();
    ArrayList<Employee>employees;
    GoogleMap map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_detail);
        Intent intent = getIntent();
        text1 = findViewById(R.id.EmpName);
        text2 = findViewById(R.id.CityEmp);
        text3 = findViewById(R.id.EmpPhone);
        text4 = findViewById(R.id.EmailEmp);
        text5 = findViewById(R.id.EmpMembership);



        first = intent.getStringExtra("first");
        last = intent.getStringExtra("last");
        city = intent.getStringExtra("city");
        country = intent.getStringExtra("country");
        phone = intent.getStringExtra("phone");
        cell = intent.getStringExtra("cell");
        latitude = intent.getStringExtra("lat");
        longitude = intent.getStringExtra("long");
        email = intent.getStringExtra("email");
        member = intent.getStringExtra("register");
        picture = intent.getStringExtra("picture");
        Log.d("DetailEmployee", "Masuk"+first+last+city);


        String membership = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        try {
            Date date = (Date) format.parse(intent.getStringExtra("register"));
            SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy");
            membership = sdf.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }



        text1.setText(first + " " + last);
        text2.setText("City: "+city + ", " +country);
        text3.setText("Phone: "+phone +" / " + cell);
        text4.setText("Email: " + email);
        text5.setText("Member Since: "+membership);


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull GoogleMap googleMap) {
                map = googleMap;
                LatLng marker = new LatLng(Double.parseDouble(latitude), Double.parseDouble(longitude));
                map.addMarker(new MarkerOptions().position(marker).title("Marker"));
                map.moveCamera(CameraUpdateFactory.newLatLng(marker));
            }
        });
        addBtn = findViewById(R.id.AddBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(EmployeeDetail.this,AddressBook.class);
                address.add(new AddressDetail(first,last,city,country,phone,email,picture));
                Log.d("ARRAY MASUK", "A is Average "+address.size()+address.get(0).getFirst());
                startActivity(intent1);
            }
        });
    }
}