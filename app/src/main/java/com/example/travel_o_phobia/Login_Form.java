package com.example.travel_o_phobia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login_Form extends AppCompatActivity {

    EditText email,password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__form);

        email=findViewById(R.id.email);
        password=findViewById(R.id.pass);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().toString().equals("admin@gmail.com") && password.getText().toString().equals("admin")){
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                }
                else {
                    Toast.makeText(getApplicationContext(),"Invalid Username & Password",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void signup_form(View view) {

        startActivity(new Intent(getApplicationContext(),Signup_Form.class));
    }

}
