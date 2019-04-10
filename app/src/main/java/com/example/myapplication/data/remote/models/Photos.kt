package com.example.myapplication.data.remote.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by Shivesh K Mehta on 8/11/19.
 * Email Id shiveshmehta09@gmail.com
 */
data class Photos(
    @SerializedName("products")
    @Expose
    var products: List<Products>?= null
)

data class Products(
    @SerializedName("productBaseInfoV1")
    @Expose
    var productInfo: ProductInfo?= null
)

data class ProductInfo(
    @SerializedName("title")
    @Expose
    var title: String?= null,
    @SerializedName("imageUrls")
    @Expose
    var imageUrls: ImageUrls?= null
)

data class ImageUrls(
    @SerializedName("200x200")
    @Expose
    var thumbnailPhoto: String?= null,
    @SerializedName("400x400")
    @Expose
    var smallPhoto: String?= null,
    @SerializedName("800x800")
    @Expose
    var largePhoto: String?= null
)