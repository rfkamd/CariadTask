package com.cariad.app.models

import com.google.gson.annotations.SerializedName


data class Connections(

    @SerializedName("ID") var ID: Int? = null,
    @SerializedName("ConnectionTypeID") var ConnectionTypeID: Int? = null,
    @SerializedName("ConnectionType") var ConnectionType: ConnectionType? = ConnectionType(),
    @SerializedName("StatusTypeID") var StatusTypeID: Int? = null,
    @SerializedName("StatusType") var StatusType: StatusType? = StatusType(),
    @SerializedName("LevelID") var LevelID: Int? = null,
    @SerializedName("Level") var Level: Level? = Level(),
    @SerializedName("PowerKW") var PowerKW: Double? = null,
    @SerializedName("CurrentTypeID") var CurrentTypeID: Int? = null,
    @SerializedName("CurrentType") var CurrentType: CurrentType? = CurrentType(),
    @SerializedName("Quantity") var Quantity: Int? = null

)