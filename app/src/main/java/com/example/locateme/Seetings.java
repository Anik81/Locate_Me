package com.example.locateme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Seetings extends AppCompatActivity implements View.OnClickListener {
    ImageView Shome, Snotification, Smap, Scontacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seetings);

        Shome = (ImageView) findViewById(R.id.imageView37);
        Snotification = (ImageView) findViewById(R.id.imageView38);
        Smap = (ImageView) findViewById(R.id.imageView39);
        Scontacts = (ImageView) findViewById(R.id.imageView40);

        Shome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SetiingsToHome = new Intent(Seetings.this, HomePage.class);
                startActivity(SetiingsToHome);
            }
        });
        Snotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SetiingsToNotification = new Intent(Seetings.this, Notification.class);
                startActivity(SetiingsToNotification);
            }
        });
        Smap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SetiingsToMap = new Intent(Seetings.this, Map.class);
                startActivity(SetiingsToMap);
            }
        });
        Scontacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SetiingsToContacts = new Intent(Seetings.this, Contacts.class);
                startActivity(SetiingsToContacts);
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}