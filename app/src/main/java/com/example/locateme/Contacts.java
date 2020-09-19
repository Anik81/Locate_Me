package com.example.locateme;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Contacts extends AppCompatActivity implements View.OnClickListener {
    ImageView Chome, Cnotification, Cmap, Csettings;
    ImageButton emergency, hospital, policeStation, rab, fireBrigade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        Chome = (ImageView) findViewById(R.id.imageView31);
        Cnotification = (ImageView) findViewById(R.id.imageView32);
        Cmap = (ImageView) findViewById(R.id.imageView33);
        Csettings = (ImageView) findViewById(R.id.imageView35);

        emergency= (ImageButton)findViewById(R.id.imageButton6);
        hospital=(ImageButton) findViewById(R.id.imageButton8);
        policeStation=(ImageButton) findViewById(R.id.imageButton7);
        rab=(ImageButton) findViewById(R.id.imageButton9);
        fireBrigade=(ImageButton) findViewById(R.id.imageButton10);

        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emergencyNum = new Intent(Contacts.this, emergencyNumber.class);
                startActivity(emergencyNum);
            }
        });
        hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hospitalNum = new Intent(Contacts.this, hospitalNumber.class);
                startActivity(hospitalNum);
            }
        });
        policeStation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent policeNum = new Intent(Contacts.this, policeStationNumber.class);
                startActivity(policeNum);
            }
        });
        rab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rabNum = new Intent(Contacts.this, RABnumber.class);
                startActivity(rabNum);
            }
        });
        fireBrigade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fireBrigadeNum = new Intent(Contacts.this, fireBrigadeNumber.class);
                startActivity(fireBrigadeNum);
            }
        });

        Chome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ContactsToHome = new Intent(Contacts.this, HomePage.class);
                startActivity(ContactsToHome);
            }
        });
        Cnotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ContactsToNotification = new Intent(Contacts.this, Notification.class);
                startActivity(ContactsToNotification);
            }
        });
        Cmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ContactsToMap = new Intent(Contacts.this, Map.class);
                startActivity(ContactsToMap);
            }
        });
        Csettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ContactsToSettings = new Intent(Contacts.this, Seetings.class);
                startActivity(ContactsToSettings);
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}