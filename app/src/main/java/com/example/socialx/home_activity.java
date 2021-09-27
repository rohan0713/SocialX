package com.example.socialx;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class home_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ArrayList<categories> list = new ArrayList<>();
        ArrayList<categories> sList = new ArrayList<>();
        ArrayList<categories> iList = new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.recycle1);
        RecyclerView sRecyclerView = findViewById(R.id.recycle2);
        RecyclerView irecyclerView = findViewById(R.id.recycle3);
        recyclerView.setLayoutManager(new LinearLayoutManager(home_activity.this,
                LinearLayoutManager.HORIZONTAL, false));

        sRecyclerView.setLayoutManager(new LinearLayoutManager(
                home_activity.this, LinearLayoutManager.HORIZONTAL, false
        ));

        irecyclerView.setLayoutManager(new GridLayoutManager(home_activity.this,
                2));

        list.add(new categories(R.drawable.toys, "Toys"));
        list.add(new categories(R.drawable.design, "Designs"));
        list.add(new categories(R.drawable.fitness, "Fitness"));
        list.add(new categories(R.drawable.headset, "Headphones"));
        list.add(new categories(R.drawable.laptop, "Laptops"));
        list.add(new categories(R.drawable.utensils, "Utensils"));
        list.add(new categories(R.drawable.toolss, "Tools"));

        sList.add(new categories(R.drawable.beds, "UP TO 20% OFF"));
        sList.add(new categories(R.drawable.camera, "UP TO 50% OFF"));
        sList.add(new categories(R.drawable.avengers, "UP TO 60% OFF"));
        sList.add(new categories(R.drawable.phones, "UP TO 20% OFF"));

        iList.add(new categories(R.drawable.beds, "Toys"));
        iList.add(new categories(R.drawable.camera, "Designs"));
        iList.add(new categories(R.drawable.avengers, "Fitness"));
        iList.add(new categories(R.drawable.phones, "Headphones"));

        recyclerView.setAdapter(new rvAdapter(list));
        recyclerView.setHasFixedSize(true);

        sRecyclerView.setAdapter(new slAdapter(sList));
        sRecyclerView.setHasFixedSize(true);

        irecyclerView.setAdapter(new iAdapter(iList));
        irecyclerView.setHasFixedSize(true);
    }
}