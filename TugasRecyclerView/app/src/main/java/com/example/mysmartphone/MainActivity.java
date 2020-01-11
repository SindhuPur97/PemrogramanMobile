package com.example.mysmartphone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvHP;
    private ArrayList<HP> list = new ArrayList<>();
    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("Dangdutkerzz");
        }

        rvHP = findViewById(R.id.rv_hp);
        rvHP.setHasFixedSize(true);

        list.addAll(DataHP.getListData());
        showRecycleList();
    }

    private void showRecycleList(){
        rvHP.setLayoutManager(new LinearLayoutManager(this));
        CardAdapter cardAdapter = new CardAdapter(list, this);
        rvHP.setAdapter(cardAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        getMenuInflater().inflate(R.menu.menu, menu);
        invalidateOptionsMenu();
        return super.onCreateOptionsMenu(menu);
    }
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();
            if(id == R.id.action_about) {
                Intent about = new Intent(this,About.class);
                startActivity(about);
            }
            return super.onOptionsItemSelected(item);
        }
}
