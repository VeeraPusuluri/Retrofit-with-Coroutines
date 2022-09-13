package com.example.retrofit_with_coroutines.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.retrofit_with_coroutines.R
import com.example.retrofit_with_coroutines.data.Posts
import com.example.retrofit_with_coroutines.databinding.RecyclerviewLayoutItemBinding

private const val TAG = "RecyclerviewAdapter"
class RecyclerviewAdapter(val photoItem:(Posts) ->Unit):ListAdapter<Posts, RecyclerviewAdapter.RecyclerviewAdapterViewHolder>(Util) {

   class RecyclerviewAdapterViewHolder(val view:RecyclerviewLayoutItemBinding):RecyclerView.ViewHolder(view.root){

       fun bind(data:Posts){
           view.recyclerviewItemId.text = data.id.toString()
           view.recyclerviewItemTitle.text = data.title
           view.recyclerviewItemImg.load(data.thumbnailUrl){
           }
       }
   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerviewAdapterViewHolder {
        Log.d(TAG,"oncreateviewholder")
      return RecyclerviewAdapterViewHolder(RecyclerviewLayoutItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerviewAdapterViewHolder, position: Int) {
        val album = getItem(position)
        Log.d(TAG,"onBindViewHolder")
        holder.bind(album)
        holder.itemView.setOnClickListener{
            photoItem(album)
        }
    }

    object Util:DiffUtil.ItemCallback<Posts>(){
        override fun areItemsTheSame(oldItem: Posts, newItem: Posts): Boolean  = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Posts, newItem: Posts): Boolean = oldItem == newItem
    }
}