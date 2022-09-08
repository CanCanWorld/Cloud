package com.zrq.cloud.bean

data class LikeSinger(val code: Int = 0,
                      val data: List<DataItem>?,
                      val hasMore: Boolean = false,
                      val count: Int = 0)

data class DataItem(val picUrl: String = "",
                    val imgVUrl: String = "",
                    val name: String = "",
                    val id: Int = 0,
                    val mvSize: Int = 0,
                    val albumSize: Int = 0,
                    val picId: Long = 0,
                    val info: String = "",
                    val trans: Any? = null)