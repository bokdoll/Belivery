package com.ppusheoppusheo.belivery.ui.order;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.ppusheoppusheo.belivery.R;
import com.ppusheoppusheo.belivery.databinding.ActivityOrderCompleteBinding;
import com.ppusheoppusheo.belivery.ui.main.MainActivity;

public class OrderComplete extends AppCompatActivity {

    ActivityOrderCompleteBinding activityOrderCompleteBinding;
    Button btn;
    Button preview;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityOrderCompleteBinding = DataBindingUtil.setContentView(this, R.layout.activity_order_complete);
        setContentView(R.layout.activity_order_complete);

        btn = activityOrderCompleteBinding.btnOrderComplete;

        Log.i("test",btn.getText()+"");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("test","dfsdfsdf");
            }
        });

    }



}
