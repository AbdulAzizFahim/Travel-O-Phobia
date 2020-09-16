package com.example.searching;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Location_Hotel_Confirm_Booking extends AppCompatActivity {

    TextView UserName,UserEmail;
    ImageView CardImages;
    EditText UserPhoneNumber,UserAddress,UserNameOnCard,UserCardNumber;
    Button ConfirmBookingButton;
    CheckBox TermsCheckBox;
    String checkBoxStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location__hotel__confirm__booking);

        UserName = (TextView) findViewById(R.id.User_Name);
        UserEmail = (TextView) findViewById(R.id.User_Email);
        CardImages = (ImageView) findViewById(R.id.Payemnt_Card_Image);
        UserPhoneNumber = (EditText) findViewById(R.id.User_PhoneNumber);
        UserAddress = (EditText) findViewById(R.id.User_Address);
        UserNameOnCard = (EditText) findViewById(R.id.User_NameOnCard);
        UserCardNumber = (EditText) findViewById(R.id.User_CardNumber);
        ConfirmBookingButton = (Button) findViewById(R.id.Confim_Booking_Button);
        TermsCheckBox = (CheckBox) findViewById(R.id.Agree_CheckBox);

        TermsCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TermsCheckBox.isChecked())
                {
                    checkBoxStatus = "yes";
                }
                else    checkBoxStatus="";
            }
        });

        ConfirmBookingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String phoneNumber = UserPhoneNumber.getText().toString();
                final String address = UserAddress.getText().toString();
                final String nameOnCard = UserNameOnCard.getText().toString();
                final String cardNumber = UserCardNumber.getText().toString();

                if(TextUtils.isEmpty(phoneNumber))
                {
                    Toast.makeText(Location_Hotel_Confirm_Booking.this, "Please Enter Phone Number", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(address))
                {
                    Toast.makeText(Location_Hotel_Confirm_Booking.this, "Please Enter Address", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(nameOnCard))
                {
                    Toast.makeText(Location_Hotel_Confirm_Booking.this, "Please Enter Name on Card", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(cardNumber))
                {
                    Toast.makeText(Location_Hotel_Confirm_Booking.this, "Please Enter Card Number", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(checkBoxStatus))
                {
                    Toast.makeText(Location_Hotel_Confirm_Booking.this, "Please Review the terms and conditions", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(Location_Hotel_Confirm_Booking.this,MainActivity.class);

                Toast.makeText(getApplicationContext(),"Booking Confirmed!",Toast.LENGTH_SHORT).show();

                startActivity(intent);
            }
        });

    }
}
