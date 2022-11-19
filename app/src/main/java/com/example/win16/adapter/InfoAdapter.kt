package com.example.win16.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.win16.InfoFragment
import com.example.win16.model.Aviator

class InfoAdapter(fragment: FragmentActivity, val list: List<Aviator>): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        val fragment = InfoFragment()
        fragment.arguments = Bundle().apply {
            putString("title",list[position].title)
            putString("desc", list[position].description)
        }
        return fragment
    }
}