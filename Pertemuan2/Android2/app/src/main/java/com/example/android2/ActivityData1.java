package com.example.android2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityData1 extends AppCompatActivity implements View.OnClickListener {
    EditText etData;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data1);

        etData = findViewById(R.id.et_data);
        btnNext = findViewById(R.id.btn_input);

        btnNext.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.btn_input){
            String data = etData.getText().toString();

            if(TextUtils.isEmpty(data)){
                etData.setError("Bangsat Kauu!!!");
            }else {
                Intent intent = new Intent(this, ActivityData2.class);
                intent.putExtra(ActivityData2.EXTRA_DATA, data);
                startActivity(intent);
            }

        }

    }

}

