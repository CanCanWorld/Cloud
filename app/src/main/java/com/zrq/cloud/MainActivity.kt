package com.zrq.cloud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.zrq.cloud.bean.LoginInfo
import com.zrq.cloud.databinding.ActivityMainBinding
import com.zrq.cloud.util.Constants.BASE_URL
import com.zrq.cloud.util.Constants.LOGIN_NUMBER
import com.zrq.cloud.util.httpPost

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        initEvent()
    }

    private fun initEvent() {
        mainBinding.btnLogin.setOnClickListener {
            val map = HashMap<String, Any>()
            map["phone"] = mainBinding.etPhone.text.toString()
            map["password"] = mainBinding.etPassword.text.toString()
            val response = httpPost(BASE_URL + LOGIN_NUMBER, map)
            Log.d(TAG, "response: $response")
            val loginInfo = Gson().fromJson(response.body, LoginInfo::class.java)
            Log.d(TAG, "loginInfo: $loginInfo")
        }
    }
}