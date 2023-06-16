package com.zahra.data.di

import android.content.Context
import android.util.Log
import com.zahra.data.BuildConfig
import com.zahra.data.StringProvider
import com.zahra.data.StringProviderImpl
import com.zahra.data.remotedata.api.ApiService
import com.zahra.data.remotedata.api.NetworkDataSource
import com.zahra.data.remotedata.api.NetworkDataSourceImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    @Singleton
    fun provideOkHttp(): OkHttpClient {
        val logging = HttpLoggingInterceptor { message ->
            Log.d("okHttpLog", message)
        }.apply {
            setLevel(
                if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor.Level.BASIC
                } else {
                    HttpLoggingInterceptor.Level.NONE
                }
            )
        }

        return OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(logging)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofitApi(client: OkHttpClient): ApiService {
        return Retrofit
            .Builder()
            .baseUrl(ApiService.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    fun provideStringProvider(@ApplicationContext appContext: Context): StringProvider {
        return StringProviderImpl(appContext)
    }

    @Provides
    fun provideNetworkDataSource(
        api: ApiService,
        stringProvider: StringProvider
    ): NetworkDataSource {
        return NetworkDataSourceImp(api, stringProvider)
    }


}