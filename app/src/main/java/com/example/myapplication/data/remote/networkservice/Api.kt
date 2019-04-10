package com.example.myapplication.data.remote.networkservice

import com.example.myapplication.data.remote.models.Photos
import com.example.myapplication.data.remote.models.TabList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Url


/**
 * Created by Shivesh K Mehta on 9/11/19.
 * Email Id shiveshmehta09@gmail.com
 */
interface Api {

    @Headers(
        "Fk-Affiliate-Id: affliatek",
        "Fk-Affiliate-Token: 9fc7f597c35b4e4e93cc7bbe40956f86"
    )
    @GET
    fun getPhotos(@Url url: String): Call<Photos>

    @Headers(
        "Fk-Affiliate-Id: affliatek",
        "Fk-Affiliate-Token: 9fc7f597c35b4e4e93cc7bbe40956f86"
    )
    @GET("api/affliatek.json")
    fun getTabs(): Call<TabList>

}