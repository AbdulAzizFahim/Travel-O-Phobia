package com.example.searching;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Location_Activity extends AppCompatActivity implements ValueEventListener{

    Button Pros_Button,Cons_Button,Trip_Review_Button,Hotel_Book_Button,Bus_Reservation_Button;
    String placeString,placeName,key,name;
    TextView placeText,location_Name_Text;
    ImageView placeImage;


    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

    DatabaseReference Coxs_Bazar = firebaseDatabase.getReference("Location_Description_Text").child("Coxs_Bazar");
    DatabaseReference Saint_Martins = firebaseDatabase.getReference("Location_Description_Text").child("Saint_Martins");
    DatabaseReference Sundarbans = firebaseDatabase.getReference("Location_Description_Text").child("Sundarbans");
    DatabaseReference Sylhet = firebaseDatabase.getReference("Location_Description_Text").child("Sylhet");



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_);

        location_Name_Text = (TextView) findViewById(R.id.Location_Name_Text);
        placeText = (TextView) findViewById(R.id.Location_Description_Text);
        placeImage = (ImageView) findViewById(R.id.Location_Image);
        Pros_Button = (Button) findViewById(R.id.Pros_Button);
        Cons_Button = (Button) findViewById(R.id.Cons_Button);
        Hotel_Book_Button = (Button) findViewById(R.id.Hotel_Book_Button);
        Trip_Review_Button = (Button) findViewById(R.id.Trip_Review_Button);

        Bundle bundle = getIntent().getExtras();

        if(bundle!=null)
        {
            placeName = bundle.getString("Location_Name");
            location_Name_Text.setText(placeName);
            name = bundle.getString("name");
        }

        placeString = "";

        Pros_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ProsIntent = new Intent(Location_Activity.this,Location_Pros.class);

                ProsIntent.putExtra("Location_Name",placeName);

                startActivity(ProsIntent);
            }
        });

        Cons_Button.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ConsIntent = new Intent(Location_Activity.this,Location_Cons.class);

                ConsIntent.putExtra("Location_Name",placeName);

                startActivity(ConsIntent);
            }
        }));

        Hotel_Book_Button.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HotelBookIntent = new Intent(Location_Activity.this,Location_Hotel_Booking.class);

                HotelBookIntent.putExtra("Location_Name",placeName);

                startActivity(HotelBookIntent);
            }
        }));

        Trip_Review_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumping();
            }
        });




        /*Bus_Reservation_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent BusReservationIntent = new Intent(Location_Activity.this,Bus_Reservation.class);

                BusReservationIntent.putExtra("Location_Name",placeName);

                startActivity(BusReservationIntent);
            }
        });*/
    }
    void jumping(){
        Intent intent = new Intent(this,ReviewOption.class);
        intent.putExtra("name" , name);
        intent.putExtra("place" , placeName);
        startActivity(intent);
    }


    public void onDataChange(@NonNull DataSnapshot snapshot) {

        if(snapshot.getValue(String.class)!=null)
        {
            key = snapshot.getKey();

            if(placeName.equals("Cox's Bazar"))
            {
                placeImage.setImageResource(R.drawable.cox3);

                if (key.equals("Coxs_Bazar")) {
                    placeString = snapshot.getValue(String.class);
                }
            }
            else if(placeName.equals("Saint Martins"))
            {
                placeImage.setImageResource(R.drawable.saint1);

                if (key.equals("Saint_Martins")) {
                    placeString = snapshot.getValue(String.class);
                }
            }
            else if(placeName.equals("Sundarbans"))
            {
                placeImage.setImageResource(R.drawable.sundar1);

                if (key.equals("Sundarbans")) {
                    placeString = snapshot.getValue(String.class);
                }
            }
            else if(placeName.equals("Sylhet"))
            {
                placeImage.setImageResource(R.drawable.sylhet1);

                if (key.equals("Sylhet")) {
                    placeString = snapshot.getValue(String.class);
                }
            }
            placeText.setText(placeString);
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {

        Toast.makeText(getApplicationContext(),"Error reading from Database!",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {

        super.onStart();
        Coxs_Bazar.addValueEventListener(this);
        Saint_Martins.addValueEventListener(this);
        Sundarbans.addValueEventListener(this);
        Sylhet.addValueEventListener(this);
    }
}
