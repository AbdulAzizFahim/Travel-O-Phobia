package com.example.searching;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class Locations extends AppCompatActivity {
    private exampleAdapter adapter;
    private List<exampleItem> exampleList;
    private String Location_Name;
    private Intent Go_to_Location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillExampleList();
        setUpRecyclerView();
    }
    private void fillExampleList() {
        exampleList = new ArrayList<>();
        exampleList.add(new exampleItem(R.drawable.ic_android_black_24dp, "Cox's Bazar", ""));
        exampleList.add(new exampleItem(R.drawable.ic_android_black_24dp, "Sundarban", ""));
        exampleList.add(new exampleItem(R.drawable.ic_android_black_24dp, "Sylhet", ""));
        exampleList.add(new exampleItem(R.drawable.ic_android_black_24dp, "Saint Martins", ""));
        /*exampleList.add(new exampleItem(R.drawable.ic_audio, "Five", "Fourteen"));
        exampleList.add(new exampleItem(R.drawable.ic_sun, "Six", "Fifteen"));
        exampleList.add(new exampleItem(R.drawable.ic_android, "Seven", "Sixteen"));
        exampleList.add(new exampleItem(R.drawable.ic_audio, "Eight", "Seventeen"));
        exampleList.add(new exampleItem(R.drawable.ic_sun, "Nine", "Eighteen"));*/
    }
    private void setUpRecyclerView() {

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        adapter = new exampleAdapter((ArrayList<exampleItem>) exampleList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new exampleAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //exampleList.get(position).changeText1("Worked");
                //adapter.notifyItemChanged(position);
                Location_Name = exampleList.get(position).getText1();

                if(Location_Name.equals("Cox's Bazar"))
                {
                    Go_to_Location = new Intent(Locations.this, Location_Activity.class);
                    Go_to_Location.putExtra("Location_Name","Cox's Bazar");
                    startActivity(Go_to_Location);
                }
                else if(Location_Name.equals("Sundarban"))
                {
                    Go_to_Location = new Intent(Locations.this, Location_Activity.class);
                    Go_to_Location.putExtra("Location_Name","Sundarbans");
                    startActivity(Go_to_Location);
                }
                else if(Location_Name.equals("Sylhet"))
                {
                    Go_to_Location = new Intent(Locations.this, Location_Activity.class);
                    Go_to_Location.putExtra("Location_Name","Sylhet");
                    startActivity(Go_to_Location);
                }
                else if(Location_Name.equals("Saint Martins"))
                {
                    Go_to_Location = new Intent(Locations.this, Location_Activity.class);
                    Go_to_Location.putExtra("Location_Name","Saint Martins");
                    startActivity(Go_to_Location);
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
}