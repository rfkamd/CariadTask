package com.cariad.app.network

import com.cariad.app.models.POI
import retrofit2.Response

interface ApiHelper {
    suspend fun getPoiList(): Response<List<POI>?>
}