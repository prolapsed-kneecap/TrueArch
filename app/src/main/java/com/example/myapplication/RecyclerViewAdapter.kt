package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerViewAdapter(var posts:Posts = Posts()):RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBing(posts[position])
    }

    override fun getItemCount() = posts.size

    inner class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var title = itemView.findViewById<TextView>(R.id.titletextView)
        var body = itemView.findViewById<TextView>(R.id.bodyTextView)

        fun onBing(post : PostsItemX){
            title.setText(post.title)
            body.setText(post.body)
        }
    }
}