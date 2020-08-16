package com.example.searching;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Signup_Form extends AppCompatActivity {

    public EditText emailId,password;
    Button btnSignUp;
    TextView tvSignIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup__form);
        getSupportActionBar().setTitle("SignUp");
    }

    public void gotologin(View view) {

        startActivity(new Intent(getApplicationContext(),Login_Form.class));
    }
}
