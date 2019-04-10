package com.example.myapplication.domain.entity


/**
 * Created by Shivesh K Mehta on 8/11/19.
 * Email Id shiveshmehta09@gmail.com
 */
data class PhotosEntity(
    val products: List<ProductsEntity>?
)

data class ProductsEntity(
    val productInfo: ProductInfoEntity?
)

data class ProductInfoEntity(
    val title: String?,
    val imageUrls: ImageUrlsEntity?
)

data class ImageUrlsEntity(
    val thumbnailPhoto: String?,
    val smallPhoto: String?,
    val largePhoto: String?
)