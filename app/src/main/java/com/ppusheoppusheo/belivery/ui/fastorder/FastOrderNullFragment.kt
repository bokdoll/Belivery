package com.ppusheoppusheo.belivery.ui.fastorder


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.ppusheoppusheo.belivery.R
import kotlinx.android.synthetic.main.fragment_fast_order_null.*

class FastOrderNullFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fast_order_null, container, false)

        initView()
    }

    private fun initView(){
    }


    private fun activateViews(){
        //rb_order_together.isChecked = true
        //setVisible(rg_order_how)
        setGone(cl_order_how_unselected)
    }

    private fun setGone(view: View) {
        view.visibility = View.GONE
    }

    private fun setVisible(view: View) {
        view.visibility = View.VISIBLE
    }

}
