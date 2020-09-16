package com.example.searching;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class Review extends AppCompatActivity
{
    RecyclerView recview;
    ReviewAdapter adapter;
    String place,name;
    String special;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){

            name = bundle.getString("name");
            place = bundle.getString("place");
            special = bundle.getString("where");
        }


        recview=(RecyclerView)findViewById(R.id.recyclerView);
        recview.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<modelR> options =
                new FirebaseRecyclerOptions.Builder<modelR>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child(special), modelR.class)
                        .build();


        adapter = new ReviewAdapter(options);
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

}