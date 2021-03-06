package com.cariad.app.models

import com.google.gson.annotations.SerializedName


data class StatusType(

    @SerializedName("IsOperational") var IsOperational: Boolean? = null,
    @SerializedName("IsUserSelectable") var IsUserSelectable: Boolean? = null,
    @SerializedName("ID") var ID: Int? = null,
    @SerializedName("Title") var Title: String? = null

)