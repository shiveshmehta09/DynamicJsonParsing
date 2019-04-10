package com.example.myapplication.data.remote.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by Shivesh K Mehta on 8/11/19.
 * Email Id shiveshmehta09@gmail.com
 */
data class TabList (
    @SerializedName("title")
    @Expose
    var title: String? = null,
    @SerializedName("description")
    @Expose
    var description: String? = null,
    @SerializedName("apiGroups")
    @Expose
    var apiGroups: ApiGroups?= null
)

data class ApiGroups (
    @SerializedName("affiliate")
    @Expose
    var affiliate: Affiliate?= null
)

data class Affiliate (
    @SerializedName("apiListings")
    @Expose
    var apiListings: Map<String, TabData>? = null
)

data class TabData (
    @SerializedName("apiName")
    @Expose
    var apiName: String? = null,
    @SerializedName("availableVariants")
    @Expose
    var version1: AvailableVariants?= null
)

data class AvailableVariants(
    @SerializedName("v1.1.0")
    @Expose
    var version1: Version1Data?= null
)

data class Version1Data(
    @SerializedName("resourceName")
    @Expose
    var resourceName: String? = null,
    @SerializedName("get")
    @Expose
    var getPhotos: String?= null
)