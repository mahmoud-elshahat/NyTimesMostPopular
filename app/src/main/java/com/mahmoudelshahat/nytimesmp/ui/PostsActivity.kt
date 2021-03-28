package com.mahmoudelshahat.nytimesmp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mahmoudelshahat.nytimesmp.R
import com.mahmoudelshahat.nytimesmp.ViewModel.PostsViewModel
import com.mahmoudelshahat.nytimesmp.ViewModel.PostsViewModelFactory
import com.mahmoudelshahat.nytimesmp.util.EspressoIdlingResource

class PostsActivity : AppCompatActivity() {
    private lateinit var viewModel: PostsViewModel
    private lateinit var mainrecycler: RecyclerView
    private var viewManager = LinearLayoutManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)

        EspressoIdlingResource.increase()

        mainrecycler = findViewById(R.id.recycler)

        val factory = PostsViewModelFactory()
        viewModel = ViewModelProviders.of(this,factory).get(PostsViewModel::class.java)


        initialiseAdapter()
    }
    private fun initialiseAdapter(){
        mainrecycler.layoutManager = viewManager
        viewModel.getAllPosts();
        observeData()
    }

    fun observeData(){
        viewModel.lst.observe(this, Observer{
            mainrecycler.adapter= PostsRecyclerAdapter(viewModel, it, this)
            EspressoIdlingResource.decrement()


        })
    }




}


