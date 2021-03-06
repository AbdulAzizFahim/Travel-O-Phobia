package com.example.searching;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements exampleAdapter.OnNoteListener
{
    RecyclerView recview;
    exampleAdapter adapter;
    String name,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){

            name = bundle.getString("name");

        }

        recview=(RecyclerView)findViewById(R.id.recyclerView);
        recview.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<modelC> options =
                new FirebaseRecyclerOptions.Builder<modelC>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Country"), modelC.class)
                        .build();


        adapter = new exampleAdapter(options,this);
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
        Intent intent = new Intent(this,Locations.class);
        intent.putExtra("name" , name);
        startActivity(intent);

    }
}