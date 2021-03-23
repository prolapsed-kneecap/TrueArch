package com.example.myapplication.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.*

class TrueFragment : Fragment() {
    companion object {
        fun newInstance() = TrueFragment()
    }
    private val viewModel: MainViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view =  inflater.inflate(R.layout.main_fragment, container, false)
        var recycler = view.findViewById<RecyclerView>(R.id.recyclerView)
        recycler.layoutManager = LinearLayoutManager(this.context)

        viewModel.posts.observe(viewLifecycleOwner){
            when (it){
                is Resource.Success -> {
                    recycler.adapter = MyRecyclerViewAdapter(it.data?: Posts())
                    view.findViewById<ProgressBar>(R.id.progressbar).visibility = View.GONE
                }
                is Resource.Loading ->{
                    view.findViewById<ProgressBar>(R.id.progressbar).visibility = View.VISIBLE
                }
            }
        }
        return view
    }

}