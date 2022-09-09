package com.zrq.cloud.util

import android.util.Log
import com.google.gson.Gson
import com.zrq.cloud.bean.Search
import okhttp3.*
import java.io.IOException
import java.lang.reflect.Type

object NetUtil {

    fun <E> netGet(url: String, type:Type): String {
        var string = ""
        val request: Request = Request.Builder()
            .url(url)
            .method("GET", null)
            .build()

        OkHttpClient().newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
            }

            override fun onResponse(call: Call, response: Response) {
                string = response.body?.string().toString()
//                fromJson = Gson().fromJson(string, type)
            }

        })
        return string
    }
}