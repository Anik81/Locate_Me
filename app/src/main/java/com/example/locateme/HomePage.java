package com.example.locateme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class HomePage extends AppCompatActivity implements View.OnClickListener {
    ImageView hnotification, hmap, hcontacts, hsettings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        hnotification = (ImageView) findViewById(R.id.imageView19);
        hmap = (ImageView) findViewById(R.id.imageView20);
        hcontacts = (ImageView) findViewById(R.id.imageView21);
        hsettings = (ImageView) findViewById(R.id.imageView22);

        hnotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent HometoNotificationIn = new Intent(HomePage.this, Notification.class);
                startActivity(HometoNotificationIn);
            }
        });
        hmap.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent HometoMapIn = new Intent(HomePage.this, Map.class);
                startActivity(HometoMapIn);
            }
        });
        hcontacts.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent HometoContactsIn = new Intent(HomePage.this, Contacts.class);
                startActivity(HometoContactsIn);
            }
        });
        hsettings.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent HometoSettingIn = new Intent(HomePage.this, Seetings.class);
                startActivity(HometoSettingIn);
            }
        });

    }

    @Override
    public void onClick(View view) {

    }
}