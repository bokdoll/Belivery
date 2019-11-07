package com.ppusheoppusheo.kakao

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //getKeyhash()

        btn_main_map.setOnClickListener{
            val intent = Intent(this@MainActivity, MapActivity::class.java)
            startActivity(intent)
        }
    }
}

