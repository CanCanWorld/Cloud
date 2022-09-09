package com.zrq.cloud

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
) : RecyclerView.Adapter<ItemSongAdapter.InnerHolder>() {

    private lateinit var itemBinding: ItemSongBinding

    inner class InnerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(position: Int) {
            if (list != null) {
                itemBinding.ivSongName.text = list!![position].name.toString()
                itemBinding.ivSinger.text = list!![position].artists[0].name.toString()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerHolder {
        itemBinding = ItemSongBinding.inflate(LayoutInflater.from(context), parent, false)
        return InnerHolder(itemBinding.root)
    }

    override fun onBindViewHolder(holder: InnerHolder, position: Int) {
        holder.setData(position)
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }
}