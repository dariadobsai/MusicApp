package com.example.android.soundtrack;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class Anime extends AppCompatActivity implements SearchView.OnQueryTextListener {

    Toolbar toolbar;
    Intent myIntent;
    Items_Adapter adapter;
    SearchView search;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_items);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);


        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        final ArrayList<SongsOrder> orders = new ArrayList<>();
        orders.add(new SongsOrder(R.drawable.anime, "Naruto Shippuden"));
        orders.add(new SongsOrder(R.drawable.anime, "Attack on Titan"));
        orders.add(new SongsOrder(R.drawable.anime, "Sword Art Online"));
        orders.add(new SongsOrder(R.drawable.anime, "Fairy Tail"));
        orders.add(new SongsOrder(R.drawable.anime, "Code Geass"));
        orders.add(new SongsOrder(R.drawable.anime, "One Piece"));
        orders.add(new SongsOrder(R.drawable.anime, "Fullmetal Alchemist"));
        orders.add(new SongsOrder(R.drawable.anime, "Tokyo Ghoul"));
        orders.add(new SongsOrder(R.drawable.anime, "Blue Exorcist"));
        orders.add(new SongsOrder(R.drawable.anime, "No Game No Life"));
        orders.add(new SongsOrder(R.drawable.anime, "Rurouni Kenshin"));


        adapter = new Items_Adapter(this, orders);

        listView = (ListView) findViewById(R.id.list_categories);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listView.getItemAtPosition(position);
                myIntent = new Intent(Anime.this, Music_listen.class);
                startActivity(myIntent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);

        search = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        search.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
