package com.zrq.cloud

import android.view.LayoutInflater
import android.view.ViewGroup
import com.zrq.cloud.databinding.FragmentPlayBinding

class PlayFragment : BaseFragment<FragmentPlayBinding>() {
    override fun providedViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentPlayBinding {
        return FragmentPlayBinding.inflate(inflater, container, false)
    }

    override fun initData() {
    }

    override fun initEvent() {
    }



}