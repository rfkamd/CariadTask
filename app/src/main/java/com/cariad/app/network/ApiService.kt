package com.cariad.app.network;

import com.cariad.app.BuildConfig
import com.cariad.app.models.POI
import com.cariad.app.utils.Constants

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("poi?key=${BuildConfig.OPEN_CHARGE_MAP_API_KEY}&distance=${Constants.MAX_DISTANCE}&distanceunit=km&latitude=${Constants.CENTER_LAT}&latitude=${Constants.CENTER_LNG}")
    suspend fun getPoiList(): Response<List<POI>?>
}
