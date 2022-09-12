package com.zrq.cloud

import android.annotation.SuppressLint
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.zrq.cloud.adapter.ItemSongAdapter
import com.zrq.cloud.adapter.OnItemClickListener
import com.zrq.cloud.bean.Search
import com.zrq.cloud.databinding.FragmentSearchSongBinding
import com.zrq.cloud.util.Constants.BASE_URL
import com.zrq.cloud.util.Constants.SEARCH_SONG
import okhttp3.*
import java.io.IOException

class SearchSongFragment : BaseFragment<FragmentSearchSongBinding>() , OnItemClickListener{

    override fun providedViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSearchSongBinding {
        return FragmentSearchSongBinding.inflate(inflater, container, false)
    }

    var list: ArrayList<Search.ResultDTO.SongsDTO>? = null
    private lateinit var adapter: ItemSongAdapter

    @SuppressLint("NotifyDataSetChanged")
    val handle: Handler = Handler(Looper.myLooper()!!) {
        when (it.what) {
            1 -> {
                adapter.notifyDataSetChanged()
            }
            else -> {}
        }
        true
    }

    override fun initData() {
        list = ArrayList()
        val manager = LinearLayoutManager(requireContext())
        mBinding.rvSearchResult.layoutManager = manager
        adapter = ItemSongAdapter(requireContext(), list, this)
        mBinding.rvSearchResult.adapter = adapter
    }

    override fun initEvent() {
        mBinding.btnSearch.setOnClickListener {
            val keyword = mBinding.etSearch.text.toString()
            val url = "$BASE_URL$SEARCH_SONG?keywords=$keyword"
            Log.d(TAG, "initEvent: $url")
            val request: Request = Request.Builder()
                .url(url)
                .method("GET", null)
                .build()

            OkHttpClient().newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    Log.d(TAG, "onFailure: ")
                }

                override fun onResponse(call: Call, response: Response) {
                    val string = response.body?.string()
                    val result = Gson().fromJson(string, Search::class.java)
                    Log.d(TAG, "onResponse: $string")
                    if (result != null) {
                        if (list != null) {
                            list!!.clear()
                            list!!.addAll(result.result.songs)
                        }
                        handle.sendMessage(Message().apply { what = 1 })
                    }
                }
            })
        }
    }

    companion object {
        fun newInstance() = SearchSongFragment()
        const val TAG = "SearchSongFragment"
    }

    override fun onClick(view: View) {
        Navigation.findNavController(requireActivity(), R.id.fragment_container).navigate(R.id.playFragment)
    }

    override fun onLongClick(view: View): Boolean {
        return true
    }
}