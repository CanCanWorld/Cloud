package com.zrq.cloud.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zrq.cloud.bean.Search
import com.zrq.cloud.databinding.ItemSongBinding

class ItemSongAdapter(
    var context: Context,
    var list: ArrayList<Search.ResultDTO.SongsDTO>?
) : RecyclerView.Adapter<VH<ItemSongBinding>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH<ItemSongBinding> {
        val mBinding: ItemSongBinding =
            ItemSongBinding.inflate(LayoutInflater.from(context), parent, false)
        return VH(mBinding)
    }

    override fun onBindViewHolder(holder: VH<ItemSongBinding>, position: Int) {
        if (list != null) {
            holder.binding.ivSongName.text = list!![position].name.toString()
            holder.binding.ivSinger.text = list!![position].artists[0].name.toString()
        }
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }
}