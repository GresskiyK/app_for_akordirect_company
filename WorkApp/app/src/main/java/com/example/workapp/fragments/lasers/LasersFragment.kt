package com.example.workapp.fragments.lasers

import android.content.ClipData
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.workapp.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.R.attr.fragment
import android.R.attr.supportsLocalInteraction
import androidx.fragment.app.FragmentManager
import android.R.attr.fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import com.example.workapp.fragments.DetailFragment


class LasersFragment : Fragment() {

    private lateinit var gridLayout: GridView
    private lateinit var progressBar: android.widget.ProgressBar
    private var items = ArrayList<ItemOfGrid>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_lasers, container, false)
        progressBar = view.findViewById(R.id.progressBar)
        gridLayout=view.findViewById(R.id.gridLayout)
        progressBar.isVisible=true
        gridLayout.setOnItemClickListener { parent, view, position, id ->

            val transaction = activity!!.supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.enter_from_right,0)
                .replace(R.id.nav_host_fragment,DetailFragment(items[position]))
                .addToBackStack("tg")
                .commit()
        }
        getData()
        return view
    }


     private fun setupAdapter(){
         progressBar.isVisible=false
         val adapter =GridAdapter(items)
         gridLayout.adapter=adapter
     }
    private fun getData() {
        val retrofit = RetrofitClass().retrofitForData()
        val service = retrofit.create(QueryForApi::class.java)
        val call = service.getCurrentData()
        call.enqueue(object : Callback<List<ServerResponse>> {
            override fun onResponse(
                call: Call<List<ServerResponse>>,
                response: Response<List<ServerResponse>>
            ) {
                val serverResponse = response.body()
                if (serverResponse!=null) {
                    for (i in 0..6) {
                        items.add(
                            ItemOfGrid(
                                serverResponse[i].model.toString(),
                                serverResponse[i].picture.toString()
                            )
                        )
                    }
                    setupAdapter()
                }
            }
            override fun onFailure(call: Call<List<ServerResponse>>, t: Throwable) {
                Log.i("errormess", t.message)
            }
        })
    }

}
