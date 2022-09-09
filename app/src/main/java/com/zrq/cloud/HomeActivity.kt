package com.zrq.cloud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.zrq.cloud.databinding.ActivityHomeBinding
import com.zrq.cloud.databinding.ActivityMainBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var homeBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(homeBinding.root)
        initData()
        initEvent()
    }

    private fun initData() {
        val list = ArrayList<Fragment>()
        list.add(LikeSingerFragment.newInstance())
        list.add(SearchSongFragment.newInstance())
        homeBinding.viewPager.adapter = ViewPagerAdapter(this, list)
    }

    private fun initEvent() {
    }
}