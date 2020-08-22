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
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class SignUpPage extends AppCompatActivity implements View.OnClickListener {
    Button backtoLogin;
    private EditText signUpEmailEditText, SignUpPasswordEditText, SignUprePasswordEditText,SignUpUserNameEditText;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);
        this.setTitle("Sign up activity");
        mAuth = FirebaseAuth.getInstance();

        SignUpUserNameEditText = findViewById(R.id.editTextTextPersonName3);
        signUpEmailEditText = findViewById(R.id.editTextTextEmailAddress);
        SignUpPasswordEditText = findViewById(R.id.editTextTextPassword2);
        SignUprePasswordEditText = findViewById(R.id.editTextTextPassword5);

        backtoLogin = (Button) findViewById(R.id.button3);
       backtoLogin.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        userRegister();


    }

    private void userRegister() {

        String username=  SignUpUserNameEditText.getText().toString().trim();
        String email= signUpEmailEditText.getText().toString().trim();
        String password= SignUpPasswordEditText.getText().toString().trim();
        String repassword= SignUprePasswordEditText.getText().toString().trim();

        if(username.isEmpty())
        {
            SignUpUserNameEditText.setError("Enter an user name");
            SignUpUserNameEditText.requestFocus();
            return;
        }
        if(email.isEmpty())
        {
            signUpEmailEditText.setError("Enter an email address");
            signUpEmailEditText.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            signUpEmailEditText.setError("Enter a valid email address");
            signUpEmailEditText.requestFocus();
            return;
        }
        if(password.isEmpty())
        {
            SignUpPasswordEditText.setError("Enter a password");
            SignUpPasswordEditText.requestFocus();
            return;
        }
        if(password.length()<6)
        {
            SignUpPasswordEditText.setError("Minimum length of a password should be 6");
            SignUpPasswordEditText.requestFocus();
            return;
        }
        if(!repassword.equals(password))
        {
            SignUprePasswordEditText.setError("Both of the passwords should be same");
            SignUprePasswordEditText.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful())
                {
                    Toast.makeText(getApplicationContext(), "Register is Successful.",Toast.LENGTH_SHORT).show();
                    Intent loginpage = new Intent(SignUpPage.this, loginpage.class);
                    startActivity(loginpage);
                }
                else
                {
                    if(task.getException() instanceof FirebaseAuthUserCollisionException)
                    {
                        Toast.makeText(getApplicationContext(), "User is already Registered",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Error: "+task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }

                }
            }
        });



    }

}




