package com.zrq.cloud

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<T : ViewBinding> : Fragment() {

    protected lateinit var mBinding: T
    protected lateinit var mainModel: MainModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = providedViewBinding(inflater, container)
        return mBinding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainModel = ViewModelProvider(requireActivity()).get(MainModel::class.java)
        initData()
        initEvent()
    }

    abstract fun providedViewBinding(inflater: LayoutInflater, container: ViewGroup?): T

    abstract fun initData()

    abstract fun initEvent()

}
