package com.example.searching;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Location_Hotel_Details extends AppCompatActivity {

    TextView Hotel_Name_Text,Hotel_Adrress_Text,Hotel_Details_Text,Hotel_Checkin,Hotel_Checkout;
    String HotelName,HotelLocationName,HotelAddress,HotelDetails;
    Button View_Deal_Button;
    private DatePickerDialog.OnDateSetListener onDateSetListener1,onDateSetListener2;
    int checkin_year,checkin_day,checkin_month,checkout_day,checkout_month,checkout_year,sum1,sum2,num1,num2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location__hotel__details);

        Hotel_Name_Text = (TextView) findViewById(R.id.hotel_name_text);
        Hotel_Adrress_Text = (TextView) findViewById(R.id.hotel_address_text);
        Hotel_Details_Text = (TextView) findViewById(R.id.hotel_details_text);
        Hotel_Checkin = (TextView) findViewById(R.id.hotel_checkin_date_text);
        Hotel_Checkout = (TextView) findViewById(R.id.hotel_checkout_date_text);
        View_Deal_Button = (Button) findViewById(R.id.hotel_deal_button);

        Bundle bundle = getIntent().getExtras();

        if(bundle!=null)
        {
            HotelLocationName = bundle.getString("Location_Name");
            HotelName = bundle.getString("Hotel_Name");
            Hotel_Name_Text.setText(HotelName);
            HotelAddress = bundle.getString("Hotel_Address_Full");
            Hotel_Adrress_Text.setText(HotelAddress);
            HotelDetails = bundle.getString("Hotel_Details_Full");
            Hotel_Details_Text.setText(HotelDetails);
        }









        Hotel_Checkin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                checkin_year = cal.get(Calendar.YEAR);
                checkin_month = cal.get(Calendar.MONTH);
                checkin_day = cal.get(Calendar.DAY_OF_MONTH);

                sum1 = checkin_day + (checkin_month+1) * 30 + checkin_year * 365;

                DatePickerDialog dialog = new DatePickerDialog(
                        Location_Hotel_Details.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        onDateSetListener1,
                        checkin_year,checkin_month,checkin_day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        onDateSetListener1 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                month++;

                String date = day + "/" + month + "/" + year;

                Hotel_Checkin.setText(date);

                sum2 = year * 365 + month * 30 + day;

            }
        };











        Hotel_Checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                checkout_year = cal.get(Calendar.YEAR);
                checkout_month = cal.get(Calendar.MONTH);
                checkout_day = cal.get(Calendar.DAY_OF_MONTH);

                num1 = checkout_day + (checkout_month + 1 ) * 30 + checkout_year * 365;

                DatePickerDialog dialog = new DatePickerDialog(
                        Location_Hotel_Details.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        onDateSetListener2,
                        checkout_year,checkout_month,checkout_day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        onDateSetListener2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                month++;

                String date = day + "/" + month + "/" + year;

                num2 = day + month * 30 + year * 365 ;

                Hotel_Checkout.setText(date);

            }
        };












        View_Deal_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(num2 < num1 || sum2 > num2 || num2 < sum1 || sum2 < sum1)
                {
                    Toast.makeText(getApplicationContext(),"Invalid Date! Select Again",Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent HotelDealIntent = new Intent(Location_Hotel_Details.this,Location_Hotel_Confirm_Booking.class);
                HotelDealIntent.putExtra("Hotel_Name",HotelName);
                HotelDealIntent.putExtra("Hotel_Location_Name",HotelLocationName);
                HotelDealIntent.putExtra("Hotel_Details_Full",HotelDetails);
                HotelDealIntent.putExtra("Hotel_Address_Full",HotelAddress);
                startActivity(HotelDealIntent);
            }
        });

    }
}