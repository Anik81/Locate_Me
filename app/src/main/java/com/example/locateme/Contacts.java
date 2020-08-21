package com.example.locateme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Contacts extends AppCompatActivity implements View.OnClickListener {
    ImageView Chome, Cnotification, Cmap, Csettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        Chome = (ImageView) findViewById(R.id.imageView31);
        Cnotification = (ImageView) findViewById(R.id.imageView32);
        Cmap = (ImageView) findViewById(R.id.imageView33);
        Csettings = (ImageView) findViewById(R.id.imageView35);

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