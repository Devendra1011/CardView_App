package com.example.cardviewapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // 1- Data
    ArrayList<GameModel> gamesList;

    // 2- Adapter View
    RecyclerView recyclerView;

    // 3 - Adapter
    MyCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recycler_view);
        gamesList = new ArrayList<>();

        gamesList.add(new GameModel("Horizon Chase",R.drawable.card1));
        gamesList.add(new GameModel("PUBG",R.drawable.card2));
        gamesList.add(new GameModel("Head Ball 2",R.drawable.card3));
        gamesList.add(new GameModel("Hooked On You",R.drawable.card4));
        gamesList.add(new GameModel("Fifa 2022",R.drawable.card5));
        gamesList.add(new GameModel("Fortnite",R.drawable.card6));

        adapter = new MyCustomAdapter(this,gamesList);


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);




    }
}