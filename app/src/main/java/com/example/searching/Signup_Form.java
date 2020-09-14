package com.example.searching;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class  Signup_Form extends AppCompatActivity {

    public EditText emailId,Password,userName,fullName,confirmPassword;
    Button btnSignUp;
    TextView tvSignIn;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup__form);
        getSupportActionBar().setTitle("SignUp");

        fullName = findViewById(R.id.fullname);
        userName = findViewById(R.id.username);
        emailId = findViewById(R.id.email);
        Password = findViewById(R.id.password);
        btnSignUp = findViewById(R.id.textView1);
        confirmPassword = findViewById(R.id.conPassword);

        databaseReference = FirebaseDatabase.getInstance().getReference("Visitor");
        firebaseAuth=FirebaseAuth.getInstance();

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String fullname = fullName.getText().toString();
                final String username = userName.getText().toString();
                final String email = emailId.getText().toString();
                String password = Password.getText().toString();
                String confirmpassword = confirmPassword.getText().toString();

                if(TextUtils.isEmpty(fullname))
                {
                    Toast.makeText(Signup_Form.this, "Please Enter Fullname", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(username))
                {
                    Toast.makeText(Signup_Form.this, "Please Enter Username", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(email))
                {
                    Toast.makeText(Signup_Form.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password))
                {
                    Toast.makeText(Signup_Form.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(confirmpassword))
                {
                    Toast.makeText(Signup_Form.this, "Please Confirm your Password", Toast.LENGTH_SHORT).show();
                    return;
                }


                if(password.length()<6)
                {
                    Toast.makeText(Signup_Form.this, "Password Too Short", Toast.LENGTH_SHORT).show();
                }

                if(password.equals(confirmpassword))
                {
                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(Signup_Form.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {

                                        visitor information = new visitor(
                                                fullname,
                                                username,
                                                email


                                        );
                                        FirebaseDatabase.getInstance().getReference("Visitor")
                                                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                                .setValue(information).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                Toast.makeText(Signup_Form.this, "Registration Complete", Toast.LENGTH_SHORT).show();
                                                startActivity(new Intent(getApplicationContext(),Login_Form.class));
                                            }
                                        });


                                    } else {

                                    }


                                }
                            });

                }






            }
        });


    }

    public void gotologin(View view) {

        Toast.makeText(getApplicationContext(),"Succesfully Registered",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(),Login_Form.class));
    }
}
