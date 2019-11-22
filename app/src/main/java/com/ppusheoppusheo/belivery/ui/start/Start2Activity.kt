package com.ppusheoppusheo.belivery.ui.start

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ppusheoppusheo.belivery.R
import kotlinx.android.synthetic.main.layout_start_2.*

class Start2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_start_2)

        iv_start_2.setOnClickListener {
            val intent = Intent(this@Start2Activity, Start3Activity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
