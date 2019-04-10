package com.example.myapplication.presentation.di

import com.example.myapplication.data.remote.networkservice.Api
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Shivesh K Mehta on 9/11/19.
 * Email Id shiveshmehta09@gmail.com
 */

@Module
class NetworkModule(private val baseUrl: String) {

    @Provides
    fun provideInterceptors(): ArrayList<Interceptor> {
        val interceptors = arrayListOf<Interceptor>()

        val keyInterceptor = Interceptor { chain ->

            val original = chain.request()
            val originalHttpUrl = original.url()

            val url = originalHttpUrl.newBuilder()
                .build()

            val requestBuilder = original.newBuilder()
                .url(url)

            val request = requestBuilder.build()
            return@Interceptor chain.proceed(request)
        }

        interceptors.add(keyInterceptor)
        return interceptors
    }

    @Provides
    fun provideRetrofit(interceptors: ArrayList<Interceptor>): Retrofit {

        val clientBuilder = OkHttpClient.Builder()
        if (!interceptors.isEmpty()) {
            interceptors.forEach { interceptor ->
                clientBuilder.addInterceptor(interceptor)
            }
        }
        return Retrofit.Builder()
            .client(
                clientBuilder
                    .connectTimeout(60, TimeUnit.MINUTES)
                    .readTimeout(60, TimeUnit.MINUTES)
                    .writeTimeout(60, TimeUnit.MINUTES)
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }


    @Provides
    fun provideApi(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }

}