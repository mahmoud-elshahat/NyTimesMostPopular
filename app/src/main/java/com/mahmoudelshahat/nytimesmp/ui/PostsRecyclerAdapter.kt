package com.mahmoudelshahat.nytimesmp.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mahmoudelshahat.nytimesmp.R
import com.mahmoudelshahat.nytimesmp.ViewModel.PostsViewModel
import com.mahmoudelshahat.nytimesmp.data.response.Post

class PostsRecyclerAdapter (val viewModel: PostsViewModel, val arrayList: ArrayList<Post>, val context: Context):
    RecyclerView.Adapter<PostsRecyclerAdapter.PostsViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): PostsRecyclerAdapter.PostsViewHolder {
        var root = LayoutInflater.from(parent.context).inflate(R.layout.mp_list_item,parent,false)
        return PostsViewHolder(root)
    }

    override fun onBindViewHolder(holder: PostsRecyclerAdapter.PostsViewHolder, position: Int) {
        holder.bind(arrayList.get(position))
    }

    override fun getItemCount(): Int {
        if(arrayList.size==0){
            Toast.makeText(context,"List is empty", Toast.LENGTH_LONG).show()
        }
        return arrayList.size
    }


    inner  class PostsViewHolder(private val binding: View) : RecyclerView.ViewHolder(binding) {
        val postImageView = binding.findViewById(R.id.postImage) as ImageView
        val postTitle = binding.findViewById(R.id.postTitle) as TextView
        val postContent = binding.findViewById(R.id.postContent) as TextView
        val postSource = binding.findViewById(R.id.postSource) as TextView
        val postDate = binding.findViewById(R.id.postDate) as TextView

        fun bind(post: Post){
            if(post.media.size>0 && post.media[0].mediaMetadata.size>0)
            {
                Glide.with(context)
                    .load(post.media[0].mediaMetadata[0].url)
                    .into(postImageView)
            }
            postTitle.text=post.title
            postContent.text=post.abstract
            postSource.text=post.source
            postDate.text=post.publishedDate

            binding.setOnClickListener(View.OnClickListener {
                val intent = Intent(context, PostDetailsActivity::class.java)
                intent.putExtra("post", post)
                context.startActivity(intent)
            })
        }

    }

}