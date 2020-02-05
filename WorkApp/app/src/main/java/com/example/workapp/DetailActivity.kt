package com.example.workapp

import android.app.PendingIntent.getActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.workapp.fragments.lasers.LasersFragment
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {
    lateinit var textViewModel: TextView
    lateinit var textViewLocation: TextView
    lateinit var img: ImageView
    lateinit var textViewTableSize: TextView
    lateinit var textViewAxis: TextView
    lateinit var textViewxyz: TextView
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        textViewModel=findViewById(R.id.textViewModel)
        textViewLocation=findViewById(R.id.textViewLocation)
        textViewAxis=findViewById(R.id.textViewAxis)
        textViewxyz=findViewById(R.id.textViewXYZ)
        button=findViewById(R.id.button1)
        textViewTableSize=findViewById(R.id.textViewTableSize)
        img=findViewById(R.id.imageViewDetail)
        Picasso.get().load(intent.getStringExtra("img")).into(img)
        textViewModel.text=intent.getStringExtra("model")
        textViewxyz.text="Объём: "+ intent.getStringExtra("x")+"x"+intent.getStringExtra("y")+"x"+intent.getStringExtra("z")+"мм"
        textViewAxis.text="Количество осей: "+intent.getStringExtra("axis")
        textViewTableSize.text="Размер стола: "+intent.getStringExtra("tableSize")
        textViewLocation.text="Местонахождение: "+intent.getStringExtra("location")
//        button.setOnClickListener {
////            val transaction = this.supportFragmentManager
////                .beginTransaction()
////                .replace(R.id.nav_host_fragment_container,LasersFragment())
////                .commit()
//        }
    }

    fun onClick(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}