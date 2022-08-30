package com.zrq.cloud.bean

data class LoginInfo(
    val code: Int = 0,
    val cookie: String = "",
    val loginType: Int = 0,
    val profile: Profile,
    val bindings: List<BindingsItem>?,
    val account: Account,
    val token: String = ""
)

data class Profile(
    val backgroundUrl: String = "",
    val detailDescription: String = "",
    val birthday: Long = 0,
    val gender: Int = 0,
    val city: Int = 0,
    val signature: String = "",
    val followeds: Int = 0,
    val description: String = "",
    val eventCount: Int = 0,
    val playlistBeSubscribedCount: Int = 0,
    val accountStatus: Int = 0,
    val avatarImgId: Long = 0,
    val defaultAvatar: Boolean = false,
    val backgroundImgIdStr: String = "",
    val province: Int = 0,
    val nickname: String = "",
    val djStatus: Int = 0,
    val avatarUrl: String = "",
    val authStatus: Int = 0,
    val follows: Int = 0,
    val vipType: Int = 0,
    val followed: Boolean = false,
    val userId: Int = 0,
    val mutual: Boolean = false,
    val avatarImgIdStr: String = "",
    val authority: Int = 0,
    val userType: Int = 0,
    val backgroundImgId: Long = 0,
    val playlistCount: Int = 0
)

data class BindingsItem(
    val expiresIn: Int = 0,
    val expired: Boolean = false,
    val tokenJsonStr: String = "",
    val refreshTime: Int = 0,
    val id: Long = 0,
    val type: Int = 0,
    val userId: Int = 0,
    val bindingTime: Long = 0,
    val url: String = ""
)

data class Account(
    val salt: String = "",
    val vipType: Int = 0,
    val userName: String = "",
    val type: Int = 0,
    val ban: Int = 0,
    val anonimousUser: Boolean = false,
    val createTime: Long = 0,
    val tokenVersion: Int = 0,
    val id: Int = 0,
    val whitelistAuthority: Int = 0,
    val baoyueVersion: Int = 0,
    val viptypeVersion: Long = 0,
    val donateVersion: Int = 0,
    val status: Int = 0,
    val uninitialized: Boolean = false
)