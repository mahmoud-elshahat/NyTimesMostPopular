package com.mahmoudelshahat.nytimesmp.data.response


import com.google.gson.annotations.SerializedName

data class NyTimesResponse(
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("num_results")
    val numResults: Int,
    @SerializedName("results")
    val results: ArrayList<Post>,
    @SerializedName("status")
    val status: String
)