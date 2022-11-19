package com.example.win16

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.fragment_info.*

class InfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPref = requireContext().getSharedPreferences("modePref", Context.MODE_PRIVATE)
        Log.i("share", sharedPref.getBoolean("mode",true).toString())
        if (sharedPref.getBoolean("mode",true)){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            text_view_title.setTextColor(Color.BLACK)
            text_view_desc.setTextColor(Color.BLACK)
        } else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
        arguments?.takeIf { it.containsKey("title") }?.apply {
            val tvTitle = view.findViewById<TextView>(R.id.text_view_title)
            tvTitle.text = getString("title")
            text_view_desc.text = getString("desc")
        }
    }
}