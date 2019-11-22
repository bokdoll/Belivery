package com.ppusheoppusheo.belivery.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.ppusheoppusheo.belivery.R;
import com.ppusheoppusheo.belivery.ui.main.MainActivity;

public class MyPageActivity extends AppCompatActivity {
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        back = findViewById(R.id.imageView20);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(MyPageActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
