package com.ppusheoppusheo.belivery.ui.map.dialog

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.ContextThemeWrapper
import android.widget.ImageView
import com.ppusheoppusheo.belivery.R
import com.ppusheoppusheo.belivery.ui.map.MapActivity
import kotlinx.android.synthetic.main.dialog_map_delivery_end.*

class DialogMapDeliveryEnd (context: Context): Dialog(context){
    private fun scanForActivity(ctx: Context?): Activity?{
        if (ctx == null)
            return null
        if (ctx is Activity)
            return ctx
        if (ctx is ContextThemeWrapper)
            return scanForActivity(ctx.baseContext)
        return null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_map_delivery_end)

        btn_dialog_map_delivery_end.setOnClickListener{
            try{
                (scanForActivity(context) as MapActivity).finish()
                dismiss()
                // ********************별점 매긴 거 서버 통신하기

            }catch(e: Exception){
                Log.e("DialogMapDeliveryEnd", e.message.toString())
            }
        }
    }

    private fun rateStars(){

    }
}