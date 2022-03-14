package com.cariad.app.di

import android.content.Context
import com.cariad.app.BuildConfig.BASE_URL
import com.cariad.app.network.ApiHelper
import com.cariad.app.network.ApiHelperImpl
import com.cariad.app.network.ApiService
import com.cariad.app.utils.NetworkHelper
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val AppModule = module {
    single { networkHelperProvider(androidContext()) }
    single { httpClientProvider() }
    single { retrofitProvider(get(), BASE_URL) }
    single { apiServiceProvider(get()) }

    single<ApiHelper> {
        return@single ApiHelperImpl(get())
    }

}




private fun networkHelperProvider(context: Context) = NetworkHelper(context)

private fun httpClientProvider() = if(BuildConfig.DEBUG){
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

}else OkHttpClient.Builder().build()

private fun retrofitProvider(httpClient: OkHttpClient, BASE_URL: String): Retrofit {
    val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation()
        .create()

    return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(httpClient)
            .build()
}

private fun apiServiceProvider(retrofit: Retrofit): ApiService=
    retrofit.create(ApiService::class.java)
