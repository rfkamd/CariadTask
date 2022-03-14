package com.cariad.app.models

import com.google.gson.annotations.SerializedName


data class SubmissionStatus(

    @SerializedName("IsLive") var IsLive: Boolean? = null,
    @SerializedName("ID") var ID: Int? = null,
    @SerializedName("Title") var Title: String? = null

)