package com.mahmoudelshahat.nytimesmp.ui

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.mahmoudelshahat.nytimesmp.R
import com.mahmoudelshahat.nytimesmp.data.response.Post
import kotlinx.android.synthetic.main.activity_post_details.*


class PostDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_details)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w: Window = window // in Activity's onCreate() for instance
            w.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }

        val post: Post = intent.getParcelableExtra("post")


        if(post.media.size>0 && post.media[0].mediaMetadata.size>0)
        {
            Glide.with(this)
                .load(post.media[0].mediaMetadata[2].url)
                .into(postImage)
        }


        article_title.setText(post.title)
        article_body.setText(post.abstract)
        article_source.setText(post.source)

        openPostLink.setOnClickListener(View.OnClickListener {
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(post.url)
            startActivity(i)
        })

    }
}