package com.example.locateme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class RABnumber extends AppCompatActivity {

    ImageButton profileToSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_a_bnumber);

        profileToSettings = (ImageButton) findViewById(R.id.imageButton12);

        profileToSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MyProfileToSetting = new Intent(RABnumber.this, Contacts.class);
                startActivity(MyProfileToSetting);
            }
        });


    }
}