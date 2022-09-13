package com.zrq.cloud

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.zrq.cloud.bean.Search
import com.zrq.cloud.databinding.FragmentPlayBinding

class PlayFragment : BaseFragment<FragmentPlayBinding>() {
    override fun providedViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentPlayBinding {
        return FragmentPlayBinding.inflate(inflater, container, false)
    }

    private var nowPlaying = Search.ResultDTO.SongsDTO()
    private lateinit var animation: ValueAnimator

    override fun initData() {
        animation = ObjectAnimator.ofFloat(mBinding.ivAlbum, "rotation", .0f, 360.0f)
        animation.apply {
            duration = 6000
            interpolator = LinearInterpolator()
            repeatCount = -1
            repeatMode = ObjectAnimator.RESTART
        }
    }

    override fun initEvent() {
        mainModel.nowPlaying.observe(this, object : Observer<Search.ResultDTO.SongsDTO> {
            override fun onChanged(s: Search.ResultDTO.SongsDTO?) {
                if (s != null) {
                    nowPlaying = s
                    refresh()
                }
            }
        })

    }

    private fun refresh() {
        mBinding.apply {
            tvSongName.text = nowPlaying.name
            var singerStr = ""
            nowPlaying.artists.forEach { singerStr = "/$it" }
            tvSinger.text = singerStr
            Glide.with(requireContext())
                .load(nowPlaying.album.picId)
                .into(ivAlbum)
        }
    }

    override fun onResume() {
        super.onResume()
        animation.start()
    }

    override fun onPause() {
        super.onPause()
        animation.pause()
    }
}