package com.ppusheoppusheo.belivery.ui.start

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ppusheoppusheo.belivery.R
import com.ppusheoppusheo.belivery.ui.main.MainActivity
import kotlinx.android.synthetic.main.layout_start_3.*

class Start3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_start_3)

        btn_start_ok.setOnClickListener {
            val intent = Intent(this@Start3Activity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
