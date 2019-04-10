package com.example.myapplication.data.remote

import com.example.myapplication.data.remote.mapper.RemoteDataMapper
import com.example.myapplication.data.remote.source.MainDataSource
import com.example.myapplication.data.remote.networkservice.Api
import com.example.myapplication.domain.entity.ProductsEntity
import com.example.myapplication.domain.entity.TabListEntity
import javax.inject.Inject

/**
 * Created by Shivesh K Mehta on 9/11/19.
 * Email Id shiveshmehta09@gmail.com
 */

class MainRemoteDataSource @Inject constructor(
    val api: Api,
    val mapper: RemoteDataMapper
) : MainDataSource {
    override fun getPhotos(url: String): List<ProductsEntity>? {
        val response = api.getPhotos(url).execute()
        try {
            if (response != null && response.isSuccessful) {
                val body = response.body()
                val responseData = body?.products
                if (responseData != null) {
                    return mapper.convertProductListToDomain(responseData)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return null
    }

    override fun getTabs(): TabListEntity? {
        val response = api.getTabs().execute()
        try {
            if (response != null && response.isSuccessful) {
                val body = response.body()
                val responseData = body
                if (responseData != null) {
                    return mapper.convertTabsToDomain(responseData)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return null    }
}