package com.example.locateme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpPage extends AppCompatActivity implements View.OnClickListener {
    Button backtoLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        backtoLogin = (Button) findViewById(R.id.button3);
        backtoLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent loginpage = new Intent(SignUpPage.this, loginpage.class);
        startActivity(loginpage);
    }
}