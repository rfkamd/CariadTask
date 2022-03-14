package com.cariad.app.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cariad.app.models.POI
import com.cariad.app.repository.RemoteDataRepository
import com.cariad.app.utils.NetworkHelper
import com.cariad.app.utils.Resource
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MapsViewModel(
    private val remoteDataRepository: RemoteDataRepository,
    private val networkHelper: NetworkHelper
) : ViewModel()  {

     val pois = MutableLiveData<Resource<List<POI>?>?>()


//    val pois: LiveData<Resource<List<POI>?>?>
//        get() = pois

    init {
        fetchData()
    }


    private fun fetchData() {
        viewModelScope.launch {
            //show loading
            pois.postValue(Resource.loading(null))
            if(networkHelper.isConnected()){
                remoteDataRepository.latestData.collect {
                    if(it == null){
                        pois.postValue(Resource.loading(null))
                    }else{
                        if(it!!.isSuccessful){
                            pois.postValue(Resource.success(it.body()))
                        }else{
                            pois.postValue(Resource.error(it.errorBody().toString(), it.body()))
                        }
                    }
                }
            }else{
                pois.postValue(Resource.error("No Internet Connection", null))
            }
        }
    }

}