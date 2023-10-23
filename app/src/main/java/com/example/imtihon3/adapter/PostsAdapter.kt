package com.example.imtihon3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.imtihon3.databinding.ItemPostBinding
import com.example.imtihon3.databinding.ItemUserBinding
import com.example.imtihon3.modelpost.PostModel

class PostsAdapter (
    val list: List<PostModel>
     ) : RecyclerView.Adapter<PostsAdapter.Vh>() {

    inner class Vh(var itemListBinding: ItemPostBinding) :
        RecyclerView.ViewHolder(itemListBinding.root) {

        fun onBind(postmodel: PostModel, position: Int) {
            itemListBinding.apply {

                title.text=postmodel.title
                body.text=postmodel.body
                userid.text=postmodel.userId.toString()


            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemPostBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position],position)
    }
    override fun getItemCount(): Int {
        return list.size
    }
}