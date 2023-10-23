package com.example.imtihon3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.imtihon3.adapter.UsersAdapter
import com.example.imtihon3.databinding.ActivityMainBinding
import com.example.imtihon3.models.UserModel
import com.example.mycontactretrofit.retrofit.UserApiClient
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val userApi = UserApiClient.userApi

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter :UsersAdapter

    private val list: ArrayList<UserModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        adapter= UsersAdapter(list) { users, position ->
            val intent=Intent(this,PostActivity::class.java)
            intent.putExtra("userId",users.id)
            startActivity(intent)
        }
        binding.rv.adapter=adapter

        binding.refresh.setOnRefreshListener {
            if (binding.refresh.isRefreshing) fetchContacts()
        }

        binding.refresh.isRefreshing = true
        fetchContacts()
    }


    private fun fetchContacts() {
        userApi.getUsers().enqueue(object : retrofit2.Callback<List<UserModel>>{
            override fun onResponse(call: retrofit2.Call<List<UserModel>>, response: Response<List<UserModel>>) {

                val contacts=response.body()
                if (response .isSuccessful && contacts!=null ){
                    list.clear()
                    list.addAll(contacts)
                    adapter.notifyDataSetChanged()
                }

                binding.refresh.isRefreshing=false
            }
            override fun onFailure(call: retrofit2.Call<List<UserModel>>, t: Throwable) {
                binding.refresh.isRefreshing=false
            }

        })
    }
}