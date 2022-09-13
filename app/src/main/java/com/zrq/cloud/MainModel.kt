package com.zrq.cloud

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zrq.cloud.bean.Search

class MainModel : ViewModel() {
    val nowPlaying = MutableLiveData<Search.ResultDTO.SongsDTO>()
}