package com.example.locateme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button enterLoginPage;
    private Object MainActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enterLoginPage=(Button) findViewById(R.id.button4);
        enterLoginPage.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent LoginView=new Intent(MainActivity.this, loginpage.class);
        startActivity(LoginView);

    }
}