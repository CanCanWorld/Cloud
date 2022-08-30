package com.zrq.cloud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zrq.cloud.databinding.ActivityHomeBinding
import com.zrq.cloud.databinding.ActivityMainBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var homeBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(homeBinding.root)
        initEvent()
    }

    private fun initEvent() {
        homeBinding.viewPager.adapter
    }
}