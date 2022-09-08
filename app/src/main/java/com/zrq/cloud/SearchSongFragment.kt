package com.zrq.cloud

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.zrq.cloud.bean.Search
import com.zrq.cloud.databinding.FragmentSearchSongBinding
import com.zrq.cloud.util.Constants.BASE_URL
import com.zrq.cloud.util.Constants.SEARCH_SONG
import com.zrq.cloud.util.NetUtil

class SearchSongFragment : BaseFragment<FragmentSearchSongBinding>() {

    companion object {
        fun newInstance() = SearchSongFragment()
        const val TAG = "SearchSongFragment"
    }

    override fun providedViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSearchSongBinding {
        return FragmentSearchSongBinding.inflate(inflater, container, false)
    }

    override fun initData() {
    }

    override fun initEvent() {
        mBinding.btnSearch.setOnClickListener {
            val keyword = mBinding.etSearch.text.toString()
            val url = "$BASE_URL$SEARCH_SONG?keyword=$keyword"
            val result = NetUtil.netGet(url, Search::class.java)
            if (result != null) {
                val songs = result.result.songs
                Log.d(TAG, "initEvent: $")
            }
        }
    }
}