package com.example.cardview_cards;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private CardAdapter adapter;

    private List<Cards> cartas;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cartas=getAllCartas();
        // Collections.shuffle(cartas);
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        adapter = new CardAdapter(cartas, R.layout.recycler_view_cards_item, this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }


    private List<Cards> getAllCartas(){
       return new ArrayList<Cards>(){{
            add(new Cards("Bokken", 1, R.drawable.cherry_bg));
            add(new Cards("Kusarigama", 2, R.drawable.cherry_bg));
            add(new Cards("Katana", 3, R.drawable.cherry_bg));
            add(new Cards("Jujitsu", 0, R.drawable.cherry_bg));
            add(new Cards("Recuperacion", 0, R.drawable.cherry_bg));
            add(new Cards("Daimio", 0, R.drawable.cherry_bg));
        }};

    }
}