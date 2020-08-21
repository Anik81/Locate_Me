package com.example.locateme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class loginpage extends AppCompatActivity implements View.OnClickListener {

    Button enterSignUpPage;
    Button enterHomePage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        enterSignUpPage = (Button) findViewById(R.id.button);
        enterSignUpPage.setOnClickListener(this);
        enterHomePage = (Button) findViewById(R.id.button2);
        enterHomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent HomepageIn = new Intent(loginpage.this, HomePage.class);
                startActivity(HomepageIn);
            }
        });

    }

    @Override
    public void onClick(View view) {
        Intent SignIn = new Intent(loginpage.this, SignUpPage.class);
        startActivity(SignIn);
    }
}

