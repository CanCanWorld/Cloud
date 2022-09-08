package com.zrq.cloud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.zrq.cloud.bean.Login
import com.zrq.cloud.databinding.ActivityMainBinding
import com.zrq.cloud.util.Constants.BASE_URL
import com.zrq.cloud.util.Constants.LOGIN_NUMBER
import okhttp3.*
import java.io.IOException

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
            //http://192.168.31.15:3000/login/cellphone?phone=17860487013&password=zhang123...
            val phone = mainBinding.etPhone.text.toString()
            val password = mainBinding.etPassword.text.toString()
            val url = "$BASE_URL$LOGIN_NUMBER?phone=$phone&password=$password"
            val request: Request = Request.Builder()
                .url(url)
                .method("GET", null)
                .build()
            OkHttpClient().newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {

                }

                override fun onResponse(call: Call, response: Response) {
                    Log.d(TAG, "response: $response")
                    if (response.body != null) {
                        val loginInfo =
                            Gson().fromJson(response.body?.string(), Login::class.java)
                        Log.d(TAG, "loginInfo: $loginInfo")
                    }
                }
            })
        }
    }
}