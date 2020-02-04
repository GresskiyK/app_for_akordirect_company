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

class LasersFragment : Fragment() {

    private lateinit var textViewLasers: TextView
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
        textViewLasers=view.findViewById(R.id.text_lasers)
        gridLayout=view.findViewById(R.id.gridLayout)
        progressBar.isVisible=true
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
                    for (i in 0..5) {
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
