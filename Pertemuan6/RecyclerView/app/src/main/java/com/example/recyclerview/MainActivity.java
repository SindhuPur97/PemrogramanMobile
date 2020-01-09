package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvHmj;
    private ArrayList<hmj> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("Himpunan Mahasiswa ITTP");
        }

        rvHmj = findViewById(R.id.rv_hmj);
        rvHmj.setHasFixedSize(true);

        list.addAll(getListHmj());
        showRecycleList();
    }

    public ArrayList<hmj> getListHmj() {
        String[] dataName = getResources().getStringArray(R.array.data_name);
        String[] dataDescription = getResources().getStringArray(R.array.data_description);
        String[] dataPhoto = getResources().getStringArray(R.array.photo);

        ArrayList<hmj> listHmj = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++){
            hmj Hmj = new hmj();
            Hmj.setName(dataName[i]);
            Hmj.setDescription(dataDescription[i]);
            Hmj.setPhoto(dataPhoto[i]);

            listHmj.add(Hmj);
        }
        return listHmj;
    }

    private void showRecycleList(){
        rvHmj.setLayoutManager(new LinearLayoutManager(this));
        ListHmjAdapter listHmjAdapter = new ListHmjAdapter(list);
        rvHmj.setAdapter(listHmjAdapter);
    }
}
