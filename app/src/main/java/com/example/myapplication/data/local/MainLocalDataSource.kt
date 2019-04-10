package com.example.myapplication.data.local

import com.example.myapplication.data.remote.source.MainDataSource
import com.example.myapplication.domain.entity.ProductsEntity
import com.example.myapplication.domain.entity.TabListEntity

/**
 * Created by Shivesh K Mehta on 9/11/19.
 * Email Id shiveshmehta09@gmail.com
 */

class MainLocalDataSource : MainDataSource {
    override fun getPhotos(url: String): List<ProductsEntity>? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getTabs(): TabListEntity? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}