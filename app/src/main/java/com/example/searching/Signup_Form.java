package com.example.searching;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup_Form extends AppCompatActivity {

    public EditText emailId,password;
    Button btnSignUp;
    TextView tvSignIn;
    DatabaseReference data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup__form);
        getSupportActionBar().setTitle("SignUp");

        emailId = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.pass);
        btnSignUp = (Button)findViewById(R.id.boton);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = FirebaseDatabase.getInstance().getReference().child("User");
                String key = data.push().getKey();
                Users hp = new Users(emailId.getText().toString(),password.getText().toString());
                data.child(key).setValue(hp);
                Toast.makeText(getApplicationContext(),"Successfully Registered",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),Login_Form.class));
            }
        });

    }


}
