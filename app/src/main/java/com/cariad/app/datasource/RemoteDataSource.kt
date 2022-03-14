package com.cariad.app.datasource

import com.cariad.app.models.POI
import com.cariad.app.network.ApiHelper
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import retrofit2.Response

class RemoteDataSource (private val apiHelper: ApiHelper, private val interval: Long){


    val dataUpdates : Flow<Response<List<POI>?>?> = flow {
        while(true){

            emit(null)
            var latest = apiHelper.getPoiList()
            emit(latest)
            delay(interval)
        }
    }


}