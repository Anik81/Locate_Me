package com.example.locateme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class editAccount extends AppCompatActivity implements View.OnClickListener {

    ImageButton profileToSettings;
    Button editProfile;
    private TextView userName,fullName, email, phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_account);

        profileToSettings = (ImageButton) findViewById(R.id.imageButton12);
        userName= (TextView) findViewById(R.id.textView);
        fullName= (TextView) findViewById(R.id.textView2);
        email= (TextView) findViewById(R.id.textView3);
        phoneNumber= (TextView) findViewById(R.id.textView4);
        editProfile = (Button) findViewById(R.id.button5);

        String edituserName = getIntent().getStringExtra("keyUserName");
        String editfullName = getIntent().getStringExtra("keyfullName");
        String editemailAddress = getIntent().getStringExtra("keyemailAddress");
        String editphoneNumber = getIntent().getStringExtra("keyphoneNumber");

        userName.setText(edituserName);
        fullName.setText(editfullName);
        email.setText(editemailAddress);
        phoneNumber.setText(editphoneNumber);

        profileToSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MyProfileToSetting = new Intent(editAccount.this, Seetings.class);
                startActivity(MyProfileToSetting);
            }
        });

        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profileEdit = new Intent(editAccount.this, EditProfile.class);
                startActivity(profileEdit);
            }
        });
    }

    @Override
    public void onClick(View view) {

    }


}