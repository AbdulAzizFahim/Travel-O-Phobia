package com.example.searching;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Location_Cons extends AppCompatActivity implements ValueEventListener {

    String consString,placeName,key,consNotReco,consStayAlert;
    TextView ConsTextView,ConsLocationName,ConsNotRecommended,ConsStayAlert;
    ImageView consSignView;

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

    DatabaseReference Coxs_Bazar_Cons = firebaseDatabase.getReference("Location_Cons").child("Coxs_Bazar").child("Cox_OverallCons");
    DatabaseReference Coxs_Bazar_NotReco = firebaseDatabase.getReference("Location_Cons").child("Coxs_Bazar").child("Cox_NotRecommended");
    DatabaseReference Coxs_Bazar_StayAlert = firebaseDatabase.getReference("Location_Cons").child("Coxs_Bazar").child("Cox_StayAlert");

    DatabaseReference Saint_Martins_Cons = firebaseDatabase.getReference("Location_Cons").child("Saint_Martins").child("Saint_Martins_OverallCons");
    DatabaseReference Saint_Martins_NotReco = firebaseDatabase.getReference("Location_Cons").child("Saint_Martins").child("Saint_Martins_NotRecommended");
    DatabaseReference Saint_Martins_StayAlert = firebaseDatabase.getReference("Location_Cons").child("Saint_Martins").child("Saint_Martins_StayAlert");


    DatabaseReference Sundarbans_Cons = firebaseDatabase.getReference("Location_Cons").child("Sundarbans").child("Sundarbans_OverallCons");
    DatabaseReference Sundarbans_NotReco = firebaseDatabase.getReference("Location_Cons").child("Sundarbans").child("Sundarbans_NotRecommended");
    DatabaseReference Sundarbans_StayAlert = firebaseDatabase.getReference("Location_Cons").child("Sundarbans").child("Sundarbans_StayAlert");

    DatabaseReference Sylhet_Cons = firebaseDatabase.getReference("Location_Cons").child("Sylhet").child("Sylhet_OverallCons");
    DatabaseReference Sylhet_NotReco = firebaseDatabase.getReference("Location_Cons").child("Sylhet").child("Sylhet_NotRecommended");
    DatabaseReference Sylhet_StayAlert = firebaseDatabase.getReference("Location_Cons").child("Sylhet").child("Sylhet_StayAlert");

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location__cons);

        consSignView = (ImageView) findViewById(R.id.consSignView);
        consSignView.setImageResource(R.drawable.cons);

        ConsTextView = (TextView) findViewById(R.id.consDescription);
        ConsNotRecommended =(TextView) findViewById(R.id.consNotRecommended);
        ConsStayAlert =(TextView) findViewById(R.id.consStayAlert);

        ConsLocationName = (TextView) findViewById(R.id.consPlace);
        consString = "";
        consNotReco = "";
        consStayAlert = "";

        Bundle bundle = getIntent().getExtras();

        if(bundle!=null)
        {
            placeName = bundle.getString("Location_Name");
        }

    }

    @Override
    public void onDataChange(@NonNull DataSnapshot snapshot) {

        if(snapshot.getValue(String.class)!=null)
        {
            key = snapshot.getKey();

            if(placeName.equals("Cox's Bazar")) {

                ConsLocationName.setText("Cox's Bazar");

                if (key.equals("Cox_OverallCons")) {

                    consString = snapshot.getValue(String.class);

                    ConsTextView.setText(consString);
                }

                if (key.equals("Cox_NotRecommended")) {

                    consNotReco = snapshot.getValue(String.class);

                    ConsNotRecommended.setText(consNotReco);
                }

                if(key.equals("Cox_StayAlert"))
                {
                    consStayAlert = snapshot.getValue(String.class);

                    ConsStayAlert.setText(consStayAlert);
                }
            }


            if(placeName.equals("Saint Martins"))
            {
                ConsLocationName.setText("Saint Martins");

                if (key.equals("Saint_Martins_OverallCons")) {

                    consString = snapshot.getValue(String.class);

                    ConsTextView.setText(consString);
                }
                if(key.equals("Saint_Martins_NotRecommended"))
                {
                    consNotReco = snapshot.getValue(String.class);

                    ConsNotRecommended.setText(consNotReco);
                }
                if(key.equals("Saint_Martins_StayAlert"))
                {
                    consStayAlert = snapshot.getValue(String.class);

                    ConsStayAlert.setText(consStayAlert);
                }
            }
            if(placeName.equals("Sundarbans"))
            {
                ConsLocationName.setText("Sundarbans");

                if (key.equals("Sundarbans_OverallCons")) {

                    consString = snapshot.getValue(String.class);

                    ConsTextView.setText(consString);
                }
                if(key.equals("Sundarbans_NotRecommended"))
                {
                    consNotReco = snapshot.getValue(String.class);

                    ConsNotRecommended.setText(consNotReco);
                }
                if(key.equals("Sundarbans_StayAlert"))
                {
                    consStayAlert = snapshot.getValue(String.class);

                    ConsStayAlert.setText(consStayAlert);
                }
            }
            if(placeName.equals("Sylhet"))
            {
                ConsLocationName.setText("Sylhet");

                if (key.equals("Sylhet_OverallCons")) {

                    consString = snapshot.getValue(String.class);

                    ConsTextView.setText(consString);
                }
                if(key.equals("Sylhet_NotRecommended"))
                {
                    consNotReco = snapshot.getValue(String.class);

                    ConsNotRecommended.setText(consNotReco);
                }
                if(key.equals("Sylhet_StayAlert"))
                {
                    consStayAlert = snapshot.getValue(String.class);

                    ConsStayAlert.setText(consStayAlert);
                }
            }
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {

    }

    @Override
    protected void onStart() {

        super.onStart();

        Coxs_Bazar_Cons.addValueEventListener(this);
        Coxs_Bazar_NotReco.addValueEventListener(this);
        Coxs_Bazar_StayAlert.addValueEventListener(this);

        Saint_Martins_Cons.addValueEventListener(this);
        Saint_Martins_NotReco.addValueEventListener(this);
        Saint_Martins_StayAlert.addValueEventListener(this);

        Sundarbans_Cons.addValueEventListener(this);
        Sundarbans_NotReco.addValueEventListener(this);
        Sundarbans_StayAlert.addValueEventListener(this);

        Sylhet_Cons.addValueEventListener(this);
        Sylhet_NotReco.addValueEventListener(this);
        Sylhet_StayAlert.addValueEventListener(this);
    }
}