package com.cariad.app.models

import com.google.gson.annotations.SerializedName


data class DataProvider(

    @SerializedName("WebsiteURL") var WebsiteURL: String? = null,
    @SerializedName("DataProviderStatusType") var DataProviderStatusType: DataProviderStatusType? = DataProviderStatusType(),
    @SerializedName("IsRestrictedEdit") var IsRestrictedEdit: Boolean? = null,
    @SerializedName("IsOpenDataLicensed") var IsOpenDataLicensed: Boolean? = null,
    @SerializedName("IsApprovedImport") var IsApprovedImport: Boolean? = null,
    @SerializedName("License") var License: String? = null,
    @SerializedName("ID") var ID: Int? = null,
    @SerializedName("Title") var Title: String? = null

)