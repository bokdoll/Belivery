package com.ppusheoppusheo.belivery.ui.order;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.ppusheoppusheo.belivery.R;
import com.ppusheoppusheo.belivery.databinding.ActivityOrderBinding;

public class OrderActivity extends AppCompatActivity {

    ActivityOrderBinding activityOrderBinding;

    Button btnComplete;
    RadioButton btnWith;
    RadioButton btnSolo;
    RadioGroup group;
    TextView price;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        activityOrderBinding = DataBindingUtil.setContentView(this, R.layout.activity_order);

        btnComplete = activityOrderBinding.btnCompeleteOrder;
        btnWith = activityOrderBinding.radioOrderSoloBtn;
        btnSolo = activityOrderBinding.radioOrderWithBtn;
        group = activityOrderBinding.radioGroupOrder;
        price = activityOrderBinding.txtOrderPrice;


        btnWith.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnWith.setButtonDrawable(R.drawable.checked);
                btnSolo.setButtonDrawable(R.drawable.check_empty);
            }
        });

        btnSolo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnSolo.setButtonDrawable(R.drawable.checked);
                btnWith.setButtonDrawable(R.drawable.check_empty);
            }
        });

        btnComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),OrderComplete.class);
                startActivity(intent);//액티비티 띄우기

            }
        });

    }

}
