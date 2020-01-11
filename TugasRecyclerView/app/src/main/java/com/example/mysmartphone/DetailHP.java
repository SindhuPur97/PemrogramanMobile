package com.example.mysmartphone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class DetailHP extends AppCompatActivity {
    private int hp_id;
    ImageView imgDetail;
    TextView tvName, tvDes;
    private ArrayList<HP> listHP = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        hp_id = getIntent().getIntExtra("hp_id",0);
        tvName = findViewById(R.id.nama_detail);
        tvDes = findViewById(R.id.desc_detail);
        imgDetail = findViewById(R.id.img_detail);

        listHP.addAll(DataHP.getListData());
        getSupportActionBar().setTitle(listHP.get(hp_id).getName());
        setLayout();

    }

    void setLayout(){
        tvName.setText(listHP.get(hp_id).getName());
        tvDes.setText(listHP.get(hp_id).getDescription());
        Glide.with(this)
                .load(listHP.get(hp_id).getPhoto())
                .apply((new RequestOptions().fitCenter()))
                .into(imgDetail);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    
}
