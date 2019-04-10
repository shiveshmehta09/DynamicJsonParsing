package com.example.myapplication.data.remote.source

import com.example.myapplication.domain.entity.ProductsEntity
import com.example.myapplication.domain.entity.TabListEntity

/**
 * Created by Shivesh K Mehta on 9/11/19.
 * Email Id shiveshmehta09@gmail.com
 */
interface MainDataSource {

    fun getTabs(
    ): TabListEntity?

    fun getPhotos(url: String): List<ProductsEntity>?
}