package com.cariad.app.network

import com.cariad.app.models.POI
import retrofit2.Response

class ApiHelperImpl(private val apiService: ApiService): ApiHelper {
    override suspend fun getPoiList(): Response<List<POI>?> = apiService.getPoiList()
}