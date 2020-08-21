package com.example.locateme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Map extends AppCompatActivity implements View.OnClickListener {
    ImageView Mhome, Mnotification, MContacts, Msettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        Mhome = (ImageView) findViewById(R.id.imageView15);
        Mnotification = (ImageView) findViewById(R.id.imageView16);
        MContacts = (ImageView) findViewById(R.id.imageView28);
        Msettings = (ImageView) findViewById(R.id.imageView30);

        Mhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MapToHome = new Intent(Map.this, HomePage.class);
                startActivity(MapToHome);
            }
        });
        Mnotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MapToNotification = new Intent(Map.this, Notification.class);
                startActivity(MapToNotification);
            }
        });
        MContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MapToContacts = new Intent(Map.this, Contacts.class);
                startActivity(MapToContacts);
            }
        });
        Msettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MapToSetting = new Intent(Map.this, Seetings.class);
                startActivity(MapToSetting);
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}