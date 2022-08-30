package com.zrq.cloud.bean.recent

data class RecentSong(
    val code: Int = 0,
    val data: Data,
    val message: String = ""
)

data class M(
    val br: Int = 0,
    val fid: Int = 0,
    val size: Int = 0,
    val vd: Int = 0
)

data class ListItem(
    val resourceId: String = "",
    val data: Data,
    val playTime: Long = 0,
    val resourceType: String = ""
)

data class L(
    val br: Int = 0,
    val fid: Int = 0,
    val size: Int = 0,
    val vd: Int = 0
)

data class H(
    val br: Int = 0,
    val fid: Int = 0,
    val size: Int = 0,
    val vd: Int = 0
)

data class Data(
    val total: Int = 0,
    val list: List<ListItem>?
)

data class ArItem(
    val name: String = "",
    val id: Int = 0
)

data class Al(
    val picUrl: String = "",
    val name: String = "",
    val id: Int = 0,
    val pic: Long = 0
)
