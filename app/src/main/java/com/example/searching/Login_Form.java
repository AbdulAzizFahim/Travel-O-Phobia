package com.example.searching;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login_Form extends AppCompatActivity {

    EditText email,password;
    Button login;
    DatabaseReference data;
    public String str;
    boolean flag = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__form);
        ImageView imageView;
        imageView = (ImageView) findViewById(R.id.logo);
        DatabaseReference dattebayo = FirebaseDatabase.getInstance().getReference("Logo");

        Glide.with(this).load("https://firebasestorage" +
                ".googleapis.com/v0/b/travel-o-phobia.appspot.com/o/logo%20and%20flag%2Ftravel.png?alt=media&token=c681b821-cf65-419b-81cd-442926723c89").into(imageView);

        //Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT).show();


        email=findViewById(R.id.email);
        password=findViewById(R.id.pass);
        login = findViewById(R.id.login);
        email.setText("");
        password.setText("");


        data = FirebaseDatabase.getInstance().getReference("User");
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                data.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for(DataSnapshot datu : snapshot.getChildren()){

                            Users user = datu.getValue(Users.class);
                            if(user.getUsername().equals(email.getText().toString()) && user.getPassword().equals(password.getText().toString()))
                                    flag= true;
                        }
                        if(flag)
                            jumpWindow();
                        else
                            Toast.makeText(getApplicationContext(),"Wrong Credentials",Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }

        });

    }

    public void signup_form(View view) {
        Intent intent = new Intent(this,Signup_Form.class);
        startActivity(intent);
    }

    public void jumpWindow(){
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("name" , email.getText().toString());
        startActivity(intent);
    }

    @Override
    protected void onRestart() {
        flag= false;
        email.setText("");
        password.setText("");
        super.onRestart();
    }
}