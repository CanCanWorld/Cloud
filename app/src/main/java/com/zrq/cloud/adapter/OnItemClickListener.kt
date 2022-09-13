package com.zrq.cloud.adapter

import android.view.View

interface OnItemClickListener {
    fun onClick(view: View, position: Int)

    fun onLongClick(view: View, position: Int): Boolean
}