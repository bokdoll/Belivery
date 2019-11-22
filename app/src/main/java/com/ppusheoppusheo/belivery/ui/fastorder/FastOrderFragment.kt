package com.ppusheoppusheo.belivery.ui.fastorder


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.ppusheoppusheo.belivery.R

class FastOrderFragment : Fragment() {

    lateinit var restaurant: String
    lateinit var menu: String
    lateinit var min_price: String
    lateinit var current_price: String
    lateinit var delivery_tip: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        if (arguments != null){
//            restaurant = arguments.getString("restaurant")!!
//        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fast_order, container, false)
    }


}
