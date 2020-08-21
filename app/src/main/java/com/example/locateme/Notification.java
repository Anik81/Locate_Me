package com.example.locateme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Notification extends AppCompatActivity implements View.OnClickListener {
    ImageView Nhome, Nmap, Ncontacts, Nsettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        Nhome = (ImageView) findViewById(R.id.imageView25);
        Nmap = (ImageView) findViewById(R.id.imageView27);
        Ncontacts = (ImageView) findViewById(R.id.imageView28);
        Nsettings = (ImageView) findViewById(R.id.imageView29);

        Nhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent NotificationToHome = new Intent(Notification.this, HomePage.class);
                startActivity(NotificationToHome);
            }
        });
        Nmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent NotificationToMap = new Intent(Notification.this, Map.class);
                startActivity(NotificationToMap);
            }
        });
        Ncontacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent NotificationToContacts = new Intent(Notification.this, Contacts.class);
                startActivity(NotificationToContacts);
            }
        });
        Nsettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent NotificationToSettings = new Intent(Notification.this, Seetings.class);
                startActivity(NotificationToSettings);
            }
        });

    }

    @Override
    public void onClick(View view) {

    }
}