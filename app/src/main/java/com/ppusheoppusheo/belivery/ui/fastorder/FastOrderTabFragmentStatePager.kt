package com.ppusheoppusheo.belivery.ui.fastorder

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import android.R
import androidx.appcompat.app.AppCompatActivity



class FastOrderTabFragmentStatePager(fm: FragmentManager, private val fragmentCount: Int) :
    FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {

        when (position) {
            0 -> {
                val fragment = FastOrderNullFragment()
                val args = Bundle()
                args.putString("restaurant", "BHC")
                args.putString("menu", "뿌링클")
                args.putString("min_price", "15,000원")
                args.putString("min_price", "5,500원")
//                args.putString("delivery_tip", "3,500원")
//                val fragmentManager = (context as AppCompatActivity).supportFragmentManager
//                val transaction = fragmentManager.beginTransaction()
//                transaction.replace(R.id.fragment_container, fragment).commitAllowingStateLoss()
                fragment.setArguments(args)

                return fragment
            }
            1 -> {
                val fragment = FastOrderNullFragment()
                val args = Bundle()
                args.putString("restaurant", "BHC")
                args.putString("menu", "뿌링클")
                args.putString("min_price", "15,000원")
                args.putString("min_price", "5,500원")
                args.putString("delivery_tip", "3,500원")
                fragment.setArguments(args)
                return fragment
            }
            2 -> {
                val fragment = FastOrderNullFragment()
                val args = Bundle()
                args.putString("restaurant", "BHC")
                args.putString("menu", "뿌링클")
                args.putString("min_price", "15,000원")
                args.putString("min_price", "5,500원")
                args.putString("delivery_tip", "3,500원")
                fragment.setArguments(args)
                return fragment
            }
            3 -> {
                val fragment = FastOrderNullFragment()
                val args = Bundle()
                args.putString("restaurant", "BHC")
                args.putString("menu", "뿌링클")
                args.putString("min_price", "15,000원")
                args.putString("min_price", "5,500원")
                args.putString("delivery_tip", "3,500원")
                fragment.setArguments(args)
                return fragment
            }
            4 -> {
                val fragment = FastOrderNullFragment()
                val args = Bundle()
                args.putString("restaurant", "BHC")
                args.putString("menu", "뿌링클")
                args.putString("min_price", "15,000원")
                args.putString("min_price", "5,500원")
                args.putString("delivery_tip", "3,500원")
                fragment.setArguments(args)
                return fragment
            }
            5 -> return FastOrderNullFragment()
            6 -> return FastOrderNullFragment()
            7 -> return FastOrderNullFragment()
            8 -> return FastOrderNullFragment()
            9 -> return FastOrderNullFragment()
            10 -> return FastOrderNullFragment()
            11 -> return FastOrderNullFragment()
            else -> return FastOrderNullFragment()
        }
    }

    override fun getCount(): Int = fragmentCount
}
