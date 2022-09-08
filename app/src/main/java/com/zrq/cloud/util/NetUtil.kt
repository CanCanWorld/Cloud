package com.zrq.cloud.util

import com.google.gson.Gson
import okhttp3.*
import java.io.IOException

object NetUtil {

    fun <E> netGet(url: String, clazz: Class<E>): E? {
        var fromJson: E? = null
        val request: Request = Request.Builder()
            .url(url)
            .method("GET", null)
            .build()

        OkHttpClient().newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
            }

            override fun onResponse(call: Call, response: Response) {
                fromJson = Gson().fromJson(response.body?.string(), clazz)
            }

        })
        return fromJson
    }
}