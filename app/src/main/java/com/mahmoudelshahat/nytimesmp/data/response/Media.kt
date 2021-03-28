package com.mahmoudelshahat.nytimesmp.data.response

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.RequiresApi
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Media(
    @SerializedName("caption")
    val caption: String,
    @SerializedName("media-metadata")
    val mediaMetadata: List<MediaMetadata>,
    @SerializedName("type")
    val type: String
) : Parcelable
