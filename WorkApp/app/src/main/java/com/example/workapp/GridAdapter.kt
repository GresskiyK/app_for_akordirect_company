package com.example.workapp

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.graphics.BitmapFactory
import android.graphics.Bitmap
import android.util.Log
import com.squareup.picasso.Picasso
import java.net.URL


class GridAdapter(private val list: List<ItemOfGrid>) : BaseAdapter() {
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.grid_item, parent, false)
        val tv=view.findViewById<TextView>(R.id.textOfItem)
        val img=view.findViewById<ImageView>(R.id.imageOfItem)
        tv.text = list[position].model
        val url = URL(list[position].urlImg).toString()
        Log.i("qwer",url)
        Picasso.get().load(url).into(img)
        return view
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return list.size
    }

}