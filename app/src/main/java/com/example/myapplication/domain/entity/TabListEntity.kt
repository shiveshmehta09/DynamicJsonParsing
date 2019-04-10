package com.example.myapplication.domain.entity

/**
 * Created by Shivesh K Mehta on 8/11/19.
 * Email Id shiveshmehta09@gmail.com
 */
data class TabListEntity(
    val title: String?,
    val description: String?,
    val apiGroups: ApiGroupsEntity?
)

data class ApiGroupsEntity(
    val affiliate: AffiliateEntity?
)

data class AffiliateEntity(
    val apiListings: Map<String, TabDataEntity>?
)

data class TabDataEntity(
    val apiName: String?,
    val version1: AvailableVariantsEntity?
)

data class AvailableVariantsEntity(
    val version1: Version1DataEntity?
)

data class Version1DataEntity(
    val resourceName: String?,
    val getPhotos: String?
)