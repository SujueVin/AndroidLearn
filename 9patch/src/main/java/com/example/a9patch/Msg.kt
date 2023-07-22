package com.example.a9patch

class Msg(val content: String,val type: Int) {
    companion object{
        const val TYPE_RECEIVED = 0 //接收消息
        const val TYPE_SENT = 1 //发送消息
    }
}