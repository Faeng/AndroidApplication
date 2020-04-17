package com.example.androidfinal;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {


    private RecyclerView listView;
    private MyAdapter adapter;
    String mTitle[] ={"Predict", "Love Song", "How to LOVE?"};
    String sTitle[] ={"Let's Predict", "Great Love Songs for Your Romantic Playlist", "Let's have a trick"};
    int image[] = {R.drawable.predict, R.drawable.couple150, R.drawable.couple150};
    private RecyclerView.LayoutManager mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        buildRecycleView();

    }

    public void buildRecycleView(){
        listView = findViewById(R.id.listView);
        listView.setHasFixedSize(true);
        mListView = new LinearLayoutManager(this);
        adapter = new MyAdapter(image,mTitle,sTitle);

        listView.setLayoutManager(mListView);
        listView.setAdapter(adapter);

        adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                if(position == 0){
                    startActivity(new Intent(MainActivity.this, PredictionPage.class));
                }
                if (position == 1){
                    startActivity(new Intent(MainActivity.this, PredictionPage.class));
                }
            }
        });
    }

}
