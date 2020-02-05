package com.example.workapp.fragments

import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.createBitmap
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.workapp.ItemOfGrid
import com.example.workapp.MainActivity
import com.example.workapp.R
import com.example.workapp.fragments.lasers.LasersFragment
import com.squareup.picasso.Picasso

class DetailFragment(val item:ItemOfGrid):Fragment() {
    lateinit var textViewModel:TextView
    lateinit var textViewLocation:TextView
    lateinit var img: ImageView
    lateinit var textViewTableSize:TextView
    lateinit var textViewAxis:TextView
    lateinit var textViewxyz:TextView
    lateinit var button:Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.detail_view, container, false)
        textViewModel=view.findViewById(R.id.textViewModel)
        textViewLocation=view.findViewById(R.id.textViewLocation)
        textViewAxis=view.findViewById(R.id.textViewAxis)
        textViewxyz=view.findViewById(R.id.textViewXYZ)
        button=view.findViewById(R.id.button1)
        textViewTableSize=view.findViewById(R.id.textViewTableSize)
        img=view.findViewById(R.id.imageViewDetail)
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        Picasso.get().load(item.urlImg).into(img)
        textViewModel.text=item.model
        button.setOnClickListener {
            val transaction = activity!!.supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(0,R.anim.close_from_left)
                .replace(R.id.nav_host_fragment,LasersFragment())
                .addToBackStack(null)
                .commit()
        }



        textViewxyz.text="Объём: "+ item.x+"x"+item.y+"x"+item.z+"мм"
        textViewAxis.text="Количество осей: "+item.axisCount
        textViewTableSize.text="Размер стола: "+item.tableSize
        textViewLocation.text="Местонахождение: "+item.location
        return view
    }
}