package com.zrq.cloud

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.zrq.cloud.bean.DataItem
import com.zrq.cloud.databinding.ItemLikeSingerBinding

class LikeSingerAdapter(
    var context: Context
) : RecyclerView.Adapter<LikeSingerAdapter.InnerHolder>() {

    var list: ArrayList<DataItem>? = ArrayList()
    lateinit var itemBinding: ItemLikeSingerBinding

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<DataItem>) {
        if (list != null) {
            list?.clear()
            list?.addAll(data)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerHolder {
        itemBinding = ItemLikeSingerBinding.inflate(LayoutInflater.from(context), parent, false)
        return InnerHolder(itemBinding.root)
    }

    override fun onBindViewHolder(holder: InnerHolder, position: Int) {
        holder.setData(position)
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    inner class InnerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(position: Int) {
            if (list != null) {
                itemBinding.tvSinger.text = list!![position].name
                Glide.with(context)
                    .load(list!![position].picUrl)
                    .into(itemBinding.ivPic)
            }
        }
    }
}