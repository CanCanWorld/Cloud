package com.zrq.cloud.util

import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException
import java.util.concurrent.TimeUnit

var client: OkHttpClient = OkHttpClient.Builder()
    .connectTimeout(20, TimeUnit.SECONDS)
    .writeTimeout(20, TimeUnit.SECONDS)
    .readTimeout(20, TimeUnit.SECONDS)
    .build()

fun httpPost(url: String, param: HashMap<String, Any>): Response {
    val builder = FormBody.Builder()
    param.forEach {
        builder.add(it.key, it.value.toString())
    }
    val formBody: FormBody = builder.build()
    val request: Request = Request.Builder()
        .post(formBody)
        .url(url)
        .build()
    val response: okhttp3.Response
    return try {
        response = client.newCall(request).execute()
        Response(response.isSuccessful, response.code, response.body?.string())
    } catch (e: IOException) {
        Response(false, 404, "IoException")
    }
}

data class Response(val success: Boolean, val code: Int, val body: String?) {
    override fun toString(): String {
        return "Response(success=$success, code=$code, body=$body)"
    }
}