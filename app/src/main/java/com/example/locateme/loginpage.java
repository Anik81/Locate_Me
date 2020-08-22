package com.example.locateme;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginpage extends AppCompatActivity implements View.OnClickListener {

    Button enterSignUpPage;
    Button enterHomePage;
    private EditText SigninPasswordEditText, signinEmailEditText;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        mAuth = FirebaseAuth.getInstance();
        this.setTitle("Login Page");
        signinEmailEditText =  findViewById(R.id.editTextTextPersonName);
        SigninPasswordEditText = findViewById(R.id.editTextTextPassword);

        enterSignUpPage = (Button) findViewById(R.id.button);
        enterSignUpPage.setOnClickListener(this);
        enterHomePage = (Button) findViewById(R.id.button2);
        enterHomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userLogin();
            }

            private void userLogin() {

                    String email= signinEmailEditText.getText().toString().trim();
                    String password= SigninPasswordEditText.getText().toString().trim();

                    if(email.isEmpty())
                    {
                        signinEmailEditText.setError("Enter an email address");
                        signinEmailEditText.requestFocus();
                        return;
                    }
                    if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
                    {
                        signinEmailEditText.setError("Enter a valid email address");
                        signinEmailEditText.requestFocus();
                        return;
                    }
                    if(password.isEmpty())
                    {
                        SigninPasswordEditText.setError("Enter a password");
                        SigninPasswordEditText.requestFocus();
                        return;
                    }
                    if(password.length()<6)
                    {
                        SigninPasswordEditText.setError("Minimum length of a password should be 6");
                        SigninPasswordEditText.requestFocus();
                        return;
                    }
                    mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful())
                            {
                                finish();
                                Intent HomepageIn = new Intent(loginpage.this, HomePage.class);
                                Toast.makeText(getApplicationContext(), "Login Successful ",Toast.LENGTH_SHORT).show();
                                startActivity(HomepageIn);
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(), "Login Unsuccessful ",Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

            }
        });

    }

    @Override
    public void onClick(View view) {
        Intent SignIn = new Intent(loginpage.this, SignUpPage.class);
        startActivity(SignIn);
    }
}

