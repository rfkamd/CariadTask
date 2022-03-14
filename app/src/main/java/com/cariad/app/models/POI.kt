package com.cariad.app.models

import com.google.gson.annotations.SerializedName


data class POI(

    @SerializedName("DataProvider") var DataProvider: DataProvider? = DataProvider(),
    @SerializedName("OperatorInfo") var OperatorInfo: OperatorInfo? = OperatorInfo(),
    @SerializedName("UsageType") var UsageType: UsageType? = UsageType(),
    @SerializedName("StatusType") var StatusType: StatusType? = StatusType(),
    @SerializedName("SubmissionStatus") var SubmissionStatus: SubmissionStatus? = SubmissionStatus(),
    @SerializedName("IsRecentlyVerified") var IsRecentlyVerified: Boolean? = null,
    @SerializedName("DateLastVerified") var DateLastVerified: String? = null,
    @SerializedName("ID") var ID: Int? = null,
    @SerializedName("UUID") var UUID: String? = null,
    @SerializedName("DataProviderID") var DataProviderID: Int? = null,
    @SerializedName("OperatorID") var OperatorID: Int? = null,
    @SerializedName("UsageTypeID") var UsageTypeID: Int? = null,
    @SerializedName("AddressInfo") var AddressInfo: AddressInfo? = AddressInfo(),
    @SerializedName("Connections") var Connections: ArrayList<Connections> = arrayListOf(),
    @SerializedName("NumberOfPoints") var NumberOfPoints: Int? = null,
    @SerializedName("StatusTypeID") var StatusTypeID: Int? = null,
    @SerializedName("DateLastStatusUpdate") var DateLastStatusUpdate: String? = null,
    @SerializedName("DataQualityLevel") var DataQualityLevel: Int? = null,
    @SerializedName("DateCreated") var DateCreated: String? = null,
    @SerializedName("SubmissionStatusTypeID") var SubmissionStatusTypeID: Int? = null

)