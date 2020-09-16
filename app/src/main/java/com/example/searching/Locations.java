package com.example.searching;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.SearchView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Locations extends AppCompatActivity implements  exampleAdapter.OnNoteListener {
    RecyclerView recview;
    exampleAdapter adapter;
    String name,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recview=(RecyclerView)findViewById(R.id.recyclerView);
        recview.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<modelC> options =
                new FirebaseRecyclerOptions.Builder<modelC>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Locations"), modelC.class)
                        .build();


        adapter = new exampleAdapter(options,this);
        recview.setAdapter(adapter);
        Bundle bundle = getIntent().getExtras();

        if(bundle!=null){

            name = bundle.getString("name");
        }

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

        Intent intent = new Intent(this,Location_Activity.class);
        intent.putExtra("Location_Name" , adapter.getItem(position).getName());
        intent.putExtra("name" , name);
        startActivity(intent);

    }


}