package com.mahmoudelshahat.nytimesmp.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PostsViewModelFactory : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(PostsViewModel::class.java)){
            return PostsViewModel() as T
        }
        throw IllegalArgumentException ("UnknownViewModel")
    }

}