package com.example.locateme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class EditProfile extends AppCompatActivity implements View.OnClickListener {
    Button SaveNewPro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        SaveNewPro = (Button) findViewById(R.id.button6);
        SaveNewPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent saveNewProfile = new Intent(EditProfile.this, ShowMyProfile.class);
                startActivity(saveNewProfile);
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}