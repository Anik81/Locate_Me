package com.example.locateme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditProfile extends AppCompatActivity implements View.OnClickListener {
    Button SaveNewPro;
    EditText name, email, phone,userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        name= findViewById(R.id.editTextTextPersonName2);
        email= findViewById(R.id.editEmailAddress);
        phone= findViewById(R.id.editPhoneNumber);
        userName= findViewById(R.id.editUserName);
        SaveNewPro = (Button) findViewById(R.id.button6);

        SaveNewPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fullName= name.getText().toString();
                String editUserName= userName.getText().toString();
                String phoneNumber= phone.getText().toString();
                String emailAddress= email.getText().toString();

                Intent saveNewProfile = new Intent(EditProfile.this, editAccount.class);
                saveNewProfile.putExtra("keyUserName", editUserName);
                saveNewProfile.putExtra("keyfullName", fullName);
                saveNewProfile.putExtra("keyphoneNumber", phoneNumber);
                saveNewProfile.putExtra("keyemailAddress", emailAddress);

                startActivity(saveNewProfile);
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}