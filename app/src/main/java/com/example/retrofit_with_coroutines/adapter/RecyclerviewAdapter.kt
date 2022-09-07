package com.example.retrofit_with_coroutines.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit_with_coroutines.data.Posts
import com.example.retrofit_with_coroutines.databinding.RecyclerviewLayoutItemBinding


class RecyclerviewAdapter:ListAdapter<Posts, RecyclerviewAdapter.RecyclerviewAdapterViewHolder>(Util) {


   class RecyclerviewAdapterViewHolder(view:RecyclerviewLayoutItemBinding):RecyclerView.ViewHolder(view.root){

   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerviewAdapterViewHolder {
      return RecyclerviewAdapterViewHolder(RecyclerviewLayoutItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerviewAdapterViewHolder, position: Int) {

    }

    object Util:DiffUtil.ItemCallback<Posts>(){
        override fun areItemsTheSame(oldItem: Posts, newItem: Posts): Boolean  = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Posts, newItem: Posts): Boolean = oldItem == newItem
    }
}