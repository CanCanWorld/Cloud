package com.zrq.cloud.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zrq.cloud.bean.Search
import com.zrq.cloud.databinding.ItemSongBinding

class ItemSongAdapter(
    private var context: Context,
    private var list: ArrayList<Search.ResultDTO.SongsDTO>?,
    private var onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<VH<ItemSongBinding>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH<ItemSongBinding> {
        val mBinding: ItemSongBinding =
            ItemSongBinding.inflate(LayoutInflater.from(context), parent, false)
        return VH(mBinding)
    }

    override fun onBindViewHolder(holder: VH<ItemSongBinding>, position: Int) {
        if (list != null) {
            holder.binding.apply {
                tvSongName.text = list!![position].name.toString()
                var singerStr = ""
                list!![position].artists.forEach { singerStr += "/$it" }
                tvSinger.text = singerStr
                tvAlbum.text = list!![position].album.name.toString()
                root.setOnClickListener {
                    onItemClickListener.onClick(it, position)
                }
                root.setOnLongClickListener {
                    onItemClickListener.onLongClick(it, position)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

}