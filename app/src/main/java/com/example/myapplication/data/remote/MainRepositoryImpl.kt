package com.example.myapplication.data.remote

import com.example.myapplication.data.remote.source.MainDataSource
import com.example.myapplication.domain.MainRepository
import com.example.myapplication.domain.entity.ProductsEntity
import com.example.myapplication.domain.entity.TabListEntity

/**
 * Created by Shivesh K Mehta on 9/11/19.
 * Email Id shiveshmehta09@gmail.com
 */

class MainRepositoryImpl(
    private val localDataSource: MainDataSource,
    private val remoteDataSource: MainDataSource
) : MainRepository {
    override fun getPhotos(url: String): List<ProductsEntity>? {
        return remoteDataSource.getPhotos(url)
    }

    override fun getTabs(): TabListEntity? {
        return remoteDataSource.getTabs()
    }

}