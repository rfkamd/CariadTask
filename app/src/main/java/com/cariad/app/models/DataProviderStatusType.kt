package com.cariad.app.models

import com.google.gson.annotations.SerializedName


data class DataProviderStatusType(

    @SerializedName("IsProviderEnabled") var IsProviderEnabled: Boolean? = null,
    @SerializedName("ID") var ID: Int? = null,
    @SerializedName("Title") var Title: String? = null

)