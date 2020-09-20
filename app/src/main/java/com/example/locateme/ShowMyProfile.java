package com.example.locateme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowMyProfile extends AppCompatActivity implements View.OnClickListener {
    ImageButton profileToSettings;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_my_profile);


        profileToSettings = (ImageButton) findViewById(R.id.imageButton12);

        profileToSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MyProfileToSetting = new Intent(ShowMyProfile.this, Seetings.class);
                startActivity(MyProfileToSetting);
            }
        });



    }

    @Override
    public void onClick(View view) {

    }
}