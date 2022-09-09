package com.zrq.cloud

import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.zrq.cloud.adapter.LikeSingerAdapter
import com.zrq.cloud.bean.DataItem
import com.zrq.cloud.bean.LikeSinger
import com.zrq.cloud.bean.Login
import com.zrq.cloud.databinding.FragmentLikeSingerBinding
import com.zrq.cloud.util.Constants
import okhttp3.*
import okio.IOException

class LikeSingerFragment : BaseFragment<FragmentLikeSingerBinding>() {

    var list: ArrayList<DataItem>? = null
    lateinit var adapter: LikeSingerAdapter

    private var handler: Handler = Handler(Looper.myLooper()!!) { msg ->
        if (msg.what == 1) {
            if (list != null) {
                adapter.setData(list!!)
            }
        }
        true
    }


    override fun initData() {
        list = ArrayList()
        adapter = LikeSingerAdapter(requireContext())
        mBinding.rvLikeSinger.adapter = adapter
        val manager = LinearLayoutManager(requireContext())
        mBinding.rvLikeSinger.layoutManager = manager
    }

    override fun initEvent() {
        mBinding.btnLikeSinger.setOnClickListener {

            val url = "${Constants.BASE_URL}${Constants.LIKE_SINGER}"
            Log.d(TAG, "url: $url")
            val request: Request = Request.Builder()
                .url(url)
                .method("GET", null)
                .build()
            OkHttpClient().newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {

                }

                override fun onResponse(call: Call, response: Response) {
                    val string = response.body?.string()
                    Log.d(TAG, "onResponse: getSinger $string")
                    if (response.body != null) {
                        val singer =
                            Gson().fromJson(string, LikeSinger::class.java)
                        val data = singer.data
                        Log.d(TAG, "onResponse: $data")
                        if (data != null && data.isNotEmpty()) {
                            list?.clear()
                            list?.addAll(data)
                            handler.sendMessage(Message().apply { what = 1 })
                        }
                        Log.d(TAG, "singerInfo: $singer")
                    }
                }
            })
        }
        mBinding.btnLogin.setOnClickListener {
            val url =
                "${Constants.BASE_URL}${Constants.LOGIN_NUMBER}?phone=17860487013&password=zhang123..."
            Log.d(TAG, "url: $url")
            val request: Request = Request.Builder()
                .url(url)
                .method("GET", null)
                .build()
            OkHttpClient().newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: java.io.IOException) {

                }

                override fun onResponse(call: Call, response: Response) {
                    val string = response.body?.string()
                    Log.d(TAG, "onResponse: login: $string")
                    if (response.body != null) {
                        val loginInfo =
                            Gson().fromJson(string, Login::class.java)
                        Log.d(TAG, "loginInfo: $loginInfo")
                    }
                }
            })
        }
    }

    companion object {
        fun newInstance() = LikeSingerFragment()
        const val TAG = "LikeSingerFragment"
    }

    override fun providedViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentLikeSingerBinding {
        return FragmentLikeSingerBinding.inflate(inflater, container, false)
    }
}