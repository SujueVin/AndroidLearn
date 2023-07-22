package com.example.a9patch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a9patch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , View.OnClickListener {

    private val msgList = ArrayList<Msg>()

    private var adapter : MsgAdapter ?= null

    private lateinit var activityMainBinding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        initMsg()
        val layoutManager = LinearLayoutManager(this)
        activityMainBinding.recyclerview.layoutManager = layoutManager
        adapter = MsgAdapter(msgList)
        activityMainBinding.recyclerview.adapter = adapter
        activityMainBinding.send.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            activityMainBinding.send ->{
                Log.d("Send","发送消息")
                val content = activityMainBinding.inputText.text.toString()
                if(content.isNotEmpty()){
                    val msg = Msg(content,Msg.TYPE_SENT)
                    msgList.add(msg)
                    adapter?.notifyItemInserted(msgList.size - 1) //当有新消息时刷新RecyclerView中的显示
                    activityMainBinding.recyclerview.scrollToPosition(msgList.size-1) //将RecyclerView定位到最后一行
                    activityMainBinding.inputText.setText("") //清空输入框中的内容
                }
            }
        }
    }

    private fun initMsg(){
        val msg1 = Msg("Hello guy.",Msg.TYPE_RECEIVED)
        msgList.add(msg1)
        val msg2 = Msg("hello,who is that?",Msg.TYPE_SENT)
        msgList.add(msg2)
        val msg3 = Msg("This is Tom. Nice talking to you.", Msg.TYPE_RECEIVED)
        msgList.add(msg3)
    }
}