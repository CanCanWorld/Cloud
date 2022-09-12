package com.zrq.cloud.adapter

import android.view.View

interface OnItemClickListener {
    fun onClick(view: View)

    fun onLongClick(view: View): Boolean
}