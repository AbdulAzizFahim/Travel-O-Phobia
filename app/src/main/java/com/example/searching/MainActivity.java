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

public class MainActivity extends AppCompatActivity {
    private exampleAdapter adapter;
    private List<exampleItem> exampleList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillExampleList();
        setUpRecyclerView();
    }
    private void fillExampleList() {
        exampleList = new ArrayList<>();
        exampleList.add(new exampleItem(R.drawable.ic_android_black_24dp, "Bangladesh", "The Bay of Bengal"));
        exampleList.add(new exampleItem(R.drawable.ic_android_black_24dp, "Singapore", "The country with Technologies"));
        /*exampleList.add(new exampleItem(R.drawable.ic_sun, "Three", "Twelve"));
        exampleList.add(new exampleItem(R.drawable.ic_android, "Four", "Thirteen"));
        exampleList.add(new exampleItem(R.drawable.ic_audio, "Five", "Fourteen"));
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
                newWindow();
            }
        });
    }


    public void newWindow(){
        Intent intent = new Intent(this,Locations.class);
        startActivity(intent);
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