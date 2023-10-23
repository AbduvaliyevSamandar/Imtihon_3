package com.example.imtihon3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.imtihon3.adapter.PostsAdapter
import com.example.imtihon3.adapter.UsersAdapter
import com.example.imtihon3.databinding.ActivityMainBinding
import com.example.imtihon3.databinding.ActivityPostBinding
import com.example.imtihon3.modelpost.PostModel
import com.example.imtihon3.models.UserModel
import com.example.imtihon3.retrofit.PostClient
import com.example.mycontactretrofit.retrofit.UserApiClient
import retrofit2.Response

class PostActivity : AppCompatActivity() {

    private val postapi=PostClient.postapi

    private lateinit var binding: ActivityPostBinding
    private lateinit var adapter : PostsAdapter

    private val list: ArrayList<PostModel> = ArrayList()
    private  val TAG = "PostActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityPostBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val userid=intent.getIntExtra("userId",-1)
        Log.d("ttt", "useridLLLLLL: "+userid )

        adapter= PostsAdapter(list)
        binding.rvpost.adapter=adapter

        binding.refresh.setOnRefreshListener {
            if (binding.refresh.isRefreshing) fetchContacts()
        }

        binding.refresh.isRefreshing = true
        fetchContacts()

    }


    private fun fetchContacts() {
        val userid=intent.getIntExtra("userId",-1)

        postapi.getpost().enqueue(object : retrofit2.Callback<List<PostModel>>{
            override fun onResponse(call: retrofit2.Call<List<PostModel>>, response: Response<List<PostModel>>) {



                val posts=response.body()
                if (response .isSuccessful && posts!=null ){
                    list.clear()

                    val userpostList=ArrayList<PostModel>()
                    posts.forEach{posts->
                        if (posts.userId==userid){
                            userpostList.add(posts)
                        }
                    }
                    list.addAll(userpostList)
                    adapter.notifyDataSetChanged()
                }
                binding.refresh.isRefreshing=false
            }
            override fun onFailure(call: retrofit2.Call<List<PostModel>>, t: Throwable) {
                binding.refresh.isRefreshing=false
            }

        })
    }
}


