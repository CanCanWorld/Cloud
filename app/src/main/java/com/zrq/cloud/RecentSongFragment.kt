package com.zrq.cloud

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import com.zrq.cloud.bean.RecentSong
import com.zrq.cloud.databinding.FragmentRecentSongBinding
import com.zrq.cloud.util.Constants.BASE_URL
import com.zrq.cloud.util.Constants.RECORD_SONG
import okhttp3.*
import okio.IOException

class RecentSongFragment : Fragment() {

    private lateinit var recentSongBinding: FragmentRecentSongBinding
    private var limit = 10

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        recentSongBinding = FragmentRecentSongBinding.inflate(layoutInflater, container, false)
        initData()
        initEvent()
        return recentSongBinding.root
    }

    private fun initData() {
        val url = "$BASE_URL$RECORD_SONG?limit=$limit"
        Log.d(TAG, "url: $url")
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
//                    val song =
//                        Gson().fromJson(response.body?.string(), RecentSong::class.java)
//                    Log.d(TAG, "loginInfo: $song")
                }
            }
        })
    }

    private fun initEvent() {

    }

    companion object {
        @JvmStatic
        fun newInstance() =
            RecentSongFragment().apply {
            }

        const val TAG = "RecentSongFragment"
    }
}