package com.mahmoudelshahat.nytimesmp.data.response


import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.RequiresApi
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Post(   @SerializedName("abstract")
                   val abstract: String,
                   @SerializedName("published_date")
                   val publishedDate: String,
                   @SerializedName("source")
                   val source: String,
                   @SerializedName("title")
                   val title: String,
                   @SerializedName("url")
                   val url: String,
                   @SerializedName("media")
                   val media: List<Media>):Parcelable {
}