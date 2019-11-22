package com.ppusheoppusheo.belivery.ui

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ppusheoppusheo.belivery.R
import com.ppusheoppusheo.belivery.ui.order.OrderActivity
import kotlinx.android.synthetic.main.activity_together_order.*
import java.util.*


class TogetherOrderActivity : AppCompatActivity() {

    private val REQUEST_CODE: Int = 1000
    private val REQUEST_COMPLETE: Int = 5000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_together_order)

        initView()
    }

    private fun initView() {
        startTimer(7, 45.0, tv_together_order_min, tv_together_order_sec)

        setGone(btn_together_order_ordered)
        setGone(cl_together_order_my_order)
        setGone(tv_together_order_ok)

        btn_together_order_unordered.setOnClickListener {
            val intent = Intent(this@TogetherOrderActivity, StoreDetailActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE)
        }

        btn_together_order_ordered.setOnClickListener {
            val intent = Intent(this@TogetherOrderActivity, OrderActivity::class.java)
            startActivityForResult(intent, REQUEST_COMPLETE)
            finish()
        }

        btn_order_together_back.setOnClickListener {
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            if (resultCode == REQUEST_CODE) {
                setGone(btn_together_order_unordered)
                setGone(tv_together_order_1)
                setGone(tv_together_order_2)
                setGone(tv_together_order_3)
                setInvisible(tv_together_order_unordered)
                setInvisible(iv_together_order_unordered)
                setVisible(btn_together_order_ordered)
                setVisible(cl_together_order_my_order)
                setVisible(tv_together_order_ok)
            }
        }
    }

    // 같이 시키리 카운트 다운 타이머
    fun startTimer(min: Int, sec: Double, tvMin: TextView, tvSec: TextView) {
        var intSec: Int = sec.toInt()
        var millisFuture: Long = ((min * 60 + intSec) * 1000).toLong()
        var countDownTimer = object : CountDownTimer(millisFuture, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                var rest_time: Long = millisUntilFinished / 1000
                var rest_min: Long = rest_time / 60
                var rest_sec: Long = rest_time % 60

                // 10보다 작으면 0 붙이기
                if (rest_min < 10) {
                    tvMin.setText(String.format(Locale.getDefault(), "0%d분", rest_min))
                } else {
                    tvMin.setText(String.format(Locale.getDefault(), "%d분", rest_min))
                }
                if (rest_sec < 10) {
                    tvSec.setText(String.format(Locale.getDefault(), " 0%d초", rest_sec))
                } else {
                    tvSec.setText(String.format(Locale.getDefault(), " %d초", rest_sec))
                }
            }

            override fun onFinish() {
                tvMin.setText("00분")
                tvSec.setText("00초")
            }
        }.start()
    }


    private fun setGone(view: View) {
        view.visibility = View.GONE
    }

    private fun setVisible(view: View) {
        view.visibility = View.VISIBLE
    }

    private fun setInvisible(view: View) {
        view.visibility = View.INVISIBLE
    }
}
