package com.cariad.app.models

import com.google.gson.annotations.SerializedName


data class OperatorInfo(

    @SerializedName("WebsiteURL") var WebsiteURL: String? = null,
    @SerializedName("IsPrivateIndividual") var IsPrivateIndividual: Boolean? = null,
    @SerializedName("IsRestrictedEdit") var IsRestrictedEdit: Boolean? = null,
    @SerializedName("ID") var ID: Int? = null,
    @SerializedName("Title") var Title: String? = null

)