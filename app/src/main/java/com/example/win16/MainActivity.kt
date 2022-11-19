package com.example.win16

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.edit
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.win16.adapter.InfoAdapter
import com.example.win16.model.Aviator
import com.onesignal.OneSignal
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_info.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : FragmentActivity() {
    val ONESIGNAL_APP_ID = "714b9f14-381d-4fc4-a93c-28d480557381"
    private lateinit var adapter: InfoAdapter
    private lateinit var viewPager: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)
        val context = this
        getData(context)
        setting()
    }

    private fun setting() {
        setting_button.setOnClickListener {
            val intent = Intent(this, SettingActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun getData(context: MainActivity) {
        val list = ArrayList<Aviator>()
        CoroutineScope(Dispatchers.IO).launch{
            val api = Api::class.java
            val apiInterface = Retrofit.Builder()
                .baseUrl("http://49.12.202.175/win16/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(api)
            val call = apiInterface.getData().awaitResponse()
            if (call.isSuccessful){
                list.addAll(call.body()!!.aviator)
            }
            launch(Dispatchers.Main) {
                adapter = InfoAdapter(context, list)
                viewPager = context.findViewById(R.id.view_pager)
                viewPager.adapter = adapter
            }
        }
    }
}