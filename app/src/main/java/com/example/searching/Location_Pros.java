package com.example.searching;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.method.ScrollingMovementMethod;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Location_Pros extends AppCompatActivity implements ValueEventListener {

    String prosString,placeName,key,prosReco,prosMustVisit;
    TextView ProsTextView,ProsLocationName,ProsRecommendation,ProsMustVisit;
    ImageView prosSignView;

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

    DatabaseReference Coxs_Bazar_Pros = firebaseDatabase.getReference("Location_Pros").child("Coxs_Bazar").child("Cox_OverallPros");
    DatabaseReference Coxs_Bazar_Reco = firebaseDatabase.getReference("Location_Pros").child("Coxs_Bazar").child("Cox_Recommendation");
    DatabaseReference Coxs_Bazar_DontMiss = firebaseDatabase.getReference("Location_Pros").child("Coxs_Bazar").child("Cox_SpotsNotToMiss");

    DatabaseReference Saint_Martins_Pros = firebaseDatabase.getReference("Location_Pros").child("Saint_Martins").child("Saint_Marins_OverallPros");
    DatabaseReference Saint_Martins_Reco = firebaseDatabase.getReference("Location_Pros").child("Saint_Martins").child("Saint_Martins_Recommendation");
    DatabaseReference Saint_Martins_DontMiss = firebaseDatabase.getReference("Location_Pros").child("Saint_Martins").child("Saint_Martins_SpotsNotToMiss");

    DatabaseReference Sundarbans_Pros = firebaseDatabase.getReference("Location_Pros").child("Sundarbans").child("Sundarbans_OverallPros");
    DatabaseReference Sundarbans_Reco = firebaseDatabase.getReference("Location_Pros").child("Sundarbans").child("Sundarbans_Recommendation");
    DatabaseReference Sundarbans_DontMiss = firebaseDatabase.getReference("Location_Pros").child("Sundarbans").child("Sundarbans_SpotsNotToMiss");

    DatabaseReference Sylhet_Pros = firebaseDatabase.getReference("Location_Pros").child("Sylhet").child("Sylhet_OverallPros");
    DatabaseReference Sylhet_Reco = firebaseDatabase.getReference("Location_Pros").child("Sylhet").child("Sylhet_Recommendation");
    DatabaseReference Sylhet_DontMiss = firebaseDatabase.getReference("Location_Pros").child("Sylhet").child("Sylhet_SpotsNotToMiss");

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location__pros);

        prosSignView = (ImageView) findViewById(R.id.prosSignView);
        prosSignView.setImageResource(R.drawable.pros);

        ProsTextView = (TextView) findViewById(R.id.prosDescription);
        ProsRecommendation =(TextView) findViewById(R.id.prosRecommendation);
        ProsMustVisit =(TextView) findViewById(R.id.prosMustVisit);

        ProsLocationName = (TextView) findViewById(R.id.prosPlace);
        prosString = "";
        prosReco = "";
        prosMustVisit = "";

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

                ProsLocationName.setText("Cox's Bazar");

                if (key.equals("Cox_OverallPros")) {

                    prosString = snapshot.getValue(String.class);

                    ProsTextView.setText(prosString);
                }

                if (key.equals("Cox_Recommendation")) {
                    prosReco = snapshot.getValue(String.class);

                    ProsRecommendation.setText(prosReco);
                }

                if(key.equals("Cox_SpotsNotToMiss"))
                {
                    prosMustVisit = snapshot.getValue(String.class);

                    ProsMustVisit.setText(prosMustVisit);
                }
            }


            if(placeName.equals("Saint Martins"))
            {
                ProsLocationName.setText("Saint Martins");

                if (key.equals("Saint_Marins_OverallPros")) {

                    prosString = snapshot.getValue(String.class);

                    ProsTextView.setText(prosString);
                }
                if(key.equals("Saint_Martins_Recommendation"))
                {
                    prosReco = snapshot.getValue(String.class);

                    ProsRecommendation.setText(prosReco);
                }
                if(key.equals("Saint_Martins_SpotsNotToMiss"))
                {
                    prosMustVisit = snapshot.getValue(String.class);

                    ProsMustVisit.setText(prosMustVisit);
                }
            }
            if(placeName.equals("Sundarbans"))
            {
                ProsLocationName.setText("Sundarbans");

                if (key.equals("Sundarbans_OverallPros")) {

                    prosString = snapshot.getValue(String.class);

                    ProsTextView.setText(prosString);
                }
                if(key.equals("Sundarbans_Recommendation"))
                {
                    prosReco = snapshot.getValue(String.class);

                    ProsRecommendation.setText(prosReco);
                }
                if(key.equals("Sundarbans_SpotsNotToMiss"))
                {
                    prosMustVisit = snapshot.getValue(String.class);

                    ProsMustVisit.setText(prosMustVisit);
                }
            }
            if(placeName.equals("Sylhet"))
            {
                ProsLocationName.setText("Sylhet");

                if (key.equals("Sylhet_OverallPros")) {

                    prosString = snapshot.getValue(String.class);

                    ProsTextView.setText(prosString);
                }
                if(key.equals("Sylhet_Recommendation"))
                {
                    prosReco = snapshot.getValue(String.class);

                    ProsRecommendation.setText(prosReco);
                }
                if(key.equals("Sylhet_SpotsNotToMiss"))
                {
                    prosMustVisit = snapshot.getValue(String.class);

                    ProsMustVisit.setText(prosMustVisit);
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

        Coxs_Bazar_Pros.addValueEventListener(this);
        Coxs_Bazar_Reco.addValueEventListener(this);
        Coxs_Bazar_DontMiss.addValueEventListener(this);

        Saint_Martins_Pros.addValueEventListener(this);
        Saint_Martins_Reco.addValueEventListener(this);
        Saint_Martins_DontMiss.addValueEventListener(this);

        Sundarbans_Pros.addValueEventListener(this);
        Sundarbans_Reco.addValueEventListener(this);
        Sundarbans_DontMiss.addValueEventListener(this);

        Sylhet_Pros.addValueEventListener(this);
        Sylhet_Reco.addValueEventListener(this);
        Sylhet_DontMiss.addValueEventListener(this);
    }
}
