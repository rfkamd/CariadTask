package com.cariad.app.models

import com.google.gson.annotations.SerializedName


data class Country(

    @SerializedName("ISOCode") var ISOCode: String? = null,
    @SerializedName("ContinentCode") var ContinentCode: String? = null,
    @SerializedName("ID") var ID: Int? = null,
    @SerializedName("Title") var Title: String? = null

)