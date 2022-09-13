package com.zrq.cloud

import android.view.LayoutInflater
import android.view.ViewGroup
import com.zrq.cloud.databinding.FragmentSingerBinding

class SingerFragment : BaseFragment<FragmentSingerBinding>() {
    override fun providedViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSingerBinding {
        return FragmentSingerBinding.inflate(inflater, container, false)
    }

    override fun initData() {
    }

    override fun initEvent() {
    }
}