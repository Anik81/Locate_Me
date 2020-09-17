package com.example.locateme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class AboutApp extends AppCompatActivity implements View.OnClickListener {
    ImageButton BacktoSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app);

        BacktoSetting = (ImageButton) findViewById(R.id.imageButton13);

        BacktoSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backToSetting = new Intent(AboutApp.this, Seetings.class);
                startActivity(backToSetting);
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}