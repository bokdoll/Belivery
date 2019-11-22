package com.ppusheoppusheo.belivery.ui.start

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ppusheoppusheo.belivery.R
import kotlinx.android.synthetic.main.layout_start_1.*

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_start_1)

        Toast.makeText(this@StartActivity, "탭해보세요!", Toast.LENGTH_SHORT).show()

            iv_start_1.setOnClickListener {
                val intent = Intent(this@StartActivity, Start2Activity::class.java)
                startActivity(intent)
                finish()
            }
//
//        var tmp  = ArrayList<Drawable?>()
//        tmp.add(ContextCompat.getDrawable(this, R.drawable.img_splash1))
//        tmp.add(ContextCompat.getDrawable(this, R.drawable.img_splash2))
    }
}
