package com.example.searching;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class Location_Hotel_Booking extends AppCompatActivity implements  Hotel_Booking_Adapter.OnNoteListener {

    RecyclerView recview;
    Hotel_Booking_Adapter adapter;
    String Hotel_Location,Go_To_Hotel_Location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location__hotel__booking);

        recview=(RecyclerView)findViewById(R.id.Hotel_Recycler_view);
        recview.setLayoutManager(new LinearLayoutManager(this));

        Bundle bundle = getIntent().getExtras();

        if(bundle!=null)
        {
            Hotel_Location = bundle.getString("Location_Name");
        }


        if(Hotel_Location.equals("Cox's Bazar"))
        {
            Go_To_Hotel_Location = "Coxs Bazar";
        }
        else if(Hotel_Location.equals("Saint Martins"))
        {
            Go_To_Hotel_Location = "Saint Martins";
        }
        else if(Hotel_Location.equals("Sundarbans"))
        {
            Go_To_Hotel_Location = "Sundarbans";
        }
        else if(Hotel_Location.equals("Sylhet"))
        {
            Go_To_Hotel_Location = "Sylhet";
        }

        FirebaseRecyclerOptions<Hotel_Item> options =  new FirebaseRecyclerOptions.Builder<Hotel_Item>()
                .setQuery(FirebaseDatabase.getInstance().getReference()
                        .child("Location_Hotel_Booking")
                        .child(Go_To_Hotel_Location), Hotel_Item.class)
                .build();

        adapter = new Hotel_Booking_Adapter(options,this);
        recview.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    public void onNoteClick(int position) {

        Intent intent = new Intent(this,Location_Hotel_Details.class);
        intent.putExtra("Hotel_Name",adapter.getItem(position).getHotel_Name());
        intent.putExtra("Location_Name",Go_To_Hotel_Location);
        intent.putExtra("Hotel_Address_Full",adapter.getItem(position).getHotel_Address());
        intent.putExtra("Hotel_Details_Full",adapter.getItem(position).getHotel_Details());
        startActivity(intent);
        //Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();
    }
}