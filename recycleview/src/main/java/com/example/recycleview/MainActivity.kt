package com.example.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    private val fruitList = ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFruits()
//        val layoutManager = LinearLayoutManager(this)
//        layoutManager.orientation = LinearLayoutManager.HORIZONTAL//横向滚动
        val layoutManager = StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
        val adapter = FruitAdapter(fruitList)
        recyclerView.adapter = adapter
    }

    private fun initFruits(){
        repeat(2){
            fruitList.add(Fruit(getRandomLengthString("Apple"),R.drawable.apple_pic))
            fruitList.add(Fruit(getRandomLengthString("Pear"),R.drawable.pear_pic))
            fruitList.add(Fruit(getRandomLengthString("Watermelon"),R.drawable.watermelon_pic))
            fruitList.add(Fruit(getRandomLengthString("Pineapple"),R.drawable.pineapple_pic))
            fruitList.add(Fruit(getRandomLengthString("Grape"),R.drawable.grape_pic))
            fruitList.add(Fruit(getRandomLengthString("Cherry"),R.drawable.cherry_pic))
            fruitList.add(Fruit(getRandomLengthString("Mango"),R.drawable.mango_pic))
            fruitList.add(Fruit(getRandomLengthString("strawberry"),R.drawable.strawberry_pic))
            fruitList.add(Fruit(getRandomLengthString("Orange"),R.drawable.orange_pic))
        }

    }

    private fun getRandomLengthString(str: String): String{
        val n = (1..20).random()
        val builder = StringBuilder()
        repeat(n){
            builder.append(str)
        }
        return builder.toString()
    }
}
