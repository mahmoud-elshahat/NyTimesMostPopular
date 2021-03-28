package com.mahmoudelshahat.nytimesmp.ViewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mahmoudelshahat.nytimesmp.data.NyTimesApiService
import com.mahmoudelshahat.nytimesmp.data.response.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


public class PostsViewModel() : ViewModel(){


    var lst = MutableLiveData<ArrayList<Post>>()
    var newlist = arrayListOf<Post>()


    fun getAllPosts(){
        val apiService = NyTimesApiService()
        GlobalScope.launch(Dispatchers.Main) {
            val response = apiService.getNyTimesMostPopular().await()
            newlist= response.results
            lst.value=newlist

        }
    }
}