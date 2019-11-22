package com.ppusheoppusheo.belivery.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ppusheoppusheo.belivery.R;
import com.ppusheoppusheo.belivery.ui.main.MainActivity;

public class FinishOrderActivity extends AppCompatActivity {

    Button back, ok;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_order);

        back = findViewById(R.id.btn_final_back);
        ok = findViewById(R.id.btn_final_ok);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FinishOrderActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FinishOrderActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
