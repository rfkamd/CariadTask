package com.cariad.app.repository

import com.cariad.app.datasource.RemoteDataSource
import com.cariad.app.models.POI
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class RemoteDataRepository (private val networkDataSource: RemoteDataSource) {
    val latestData: Flow<Response<List<POI>?>?> = networkDataSource.dataUpdates
}