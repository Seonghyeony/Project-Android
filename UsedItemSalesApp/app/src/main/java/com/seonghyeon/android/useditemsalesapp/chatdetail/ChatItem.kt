package com.seonghyeon.android.useditemsalesapp.chatdetail

data class ChatItem(
    val senderId: String,
    val message: String
) {
    constructor(): this("", "")
}