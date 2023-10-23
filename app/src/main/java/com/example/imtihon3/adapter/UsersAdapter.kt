package com.example.imtihon3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.imtihon3.databinding.ItemUserBinding
import com.example.imtihon3.modelpost.PostModel
import com.example.imtihon3.models.UserModel

class UsersAdapter(
    val list: List<UserModel>,
    val onItemClick: (UserModel,Int) -> Unit ) : RecyclerView.Adapter<UsersAdapter.Vh>() {

    inner class Vh(var itemListBinding: ItemUserBinding) :
        RecyclerView.ViewHolder(itemListBinding.root) {

        fun onBind(userModel: UserModel, position: Int) {
            itemListBinding.apply {

                name.text="Name: "+userModel.name
                email.text="Email: "+ userModel.email
                NameB.text=userModel.name.substring(0,1)
                street.text="Street: "+userModel.address.street
                city.text="City: "+userModel.address.city
                username.text="User name: "+userModel.username

                itemView.setOnClickListener { onItemClick.invoke(userModel,position) }

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemUserBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position],position)
    }
}