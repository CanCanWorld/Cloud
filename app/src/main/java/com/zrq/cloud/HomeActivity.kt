package com.zrq.cloud

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.zrq.cloud.adapter.ViewPagerAdapter
import com.zrq.cloud.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var homeBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeBinding = ActivityHomeBinding.inflate(layoutInflater)
        initData()
        initEvent()
    }

    private fun initData() {
    }

    private fun initEvent() {
    }

//    override fun onSupportNavigateUp(): Boolean = findNavController(R.id.fragment_container).navigateUp()
}