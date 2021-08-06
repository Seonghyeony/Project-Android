package com.seonghyeon.android.useditemsalesapp.chatlist

data class ChatListItem(
    val buyerId: String,
    val sellerId: String,
    val itemTitle: String,
    val key: Long   // 현재 시간을 기반한 랜덤 값을 사용하는게 좋다.
) {
    constructor(): this("", "", "", 0)
}
