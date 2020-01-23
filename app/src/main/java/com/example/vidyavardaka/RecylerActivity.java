package com.example.vidyavardaka;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecylerActivity  extends AppCompatActivity {
    DemoAdapter demoAdapter;
    RecyclerView recycler;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        recycler=findViewById(R.id.recylerView);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);
        recycler.setHasFixedSize(true);
        demoAdapter=new DemoAdapter();
        recycler.setAdapter(demoAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       MenuInflater menuInflater=getMenuInflater();
       menuInflater.inflate(R.menu.setting,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
