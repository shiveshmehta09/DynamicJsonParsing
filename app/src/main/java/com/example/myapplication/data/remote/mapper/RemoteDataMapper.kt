package com.example.myapplication.data.remote.mapper

import com.example.myapplication.data.remote.models.*
import com.example.myapplication.domain.entity.*
import javax.inject.Inject

/**
 * Created by Shivesh K Mehta on 9/11/19.
 * Email Id shiveshmehta09@gmail.com
 */

class RemoteDataMapper @Inject constructor() {

    fun convertPhotoListToDomain(fromItems: List<Photos>?): List<PhotosEntity> {
        val photoResponseList = ArrayList<PhotosEntity>()
        fromItems?.forEach { photoResponseList.add(convertPhotoToDomain(it)) }
        return photoResponseList
    }

    fun convertPhotoToDomain(fromPhoto: Photos) = PhotosEntity(
        convertProductListToDomain(fromPhoto.products)
    )

    fun convertProductListToDomain(fromItems: List<Products>?): List<ProductsEntity> {
        val productResponseList = ArrayList<ProductsEntity>()
        fromItems?.forEach { productResponseList.add(convertProductToDomain(it)) }
        return productResponseList
    }

    fun convertProductToDomain(fromProduct: Products) = ProductsEntity(
        if (fromProduct.productInfo == null) null else convertProductInfoToDomain(fromProduct.productInfo)
    )

    fun convertProductInfoToDomain(optionItem: ProductInfo?) = ProductInfoEntity(
        optionItem?.title,
        if (optionItem?.imageUrls == null) null else convertImageUrlToDomain(optionItem.imageUrls)
    )

    fun convertImageUrlToDomain(optionItem: ImageUrls?) = ImageUrlsEntity(
        optionItem?.thumbnailPhoto,
        optionItem?.smallPhoto,
        optionItem?.largePhoto
    )


    fun convertTabsToDomain(fromTab: TabList) = TabListEntity(
        fromTab.title,
        fromTab.description,
        if (fromTab.apiGroups == null) null else convertApiGroupToDomain(fromTab.apiGroups)
    )

    fun convertApiGroupToDomain(fromGroup: ApiGroups?) = ApiGroupsEntity(
        if (fromGroup?.affiliate == null) null else convertAffiliateToDomain(fromGroup.affiliate)
    )

    fun convertAffiliateToDomain(fromAffiliate: Affiliate?) = AffiliateEntity(
        if (fromAffiliate?.apiListings == null) null else convertApiListingToDomain(fromAffiliate.apiListings)
    )


    fun convertApiListingToDomain(fromMap: Map<String, TabData>?): Map<String, TabDataEntity>? {

        val attemptsMap = HashMap<String, TabDataEntity>()
        for (key in fromMap!!.keys) {
            attemptsMap[key] = convertAttemptsListToDomain(fromMap[key]!!)
        }
        return attemptsMap
    }

    fun convertAttemptsListToDomain(fromAttempts: TabData?) = TabDataEntity(
        fromAttempts?.apiName,
        if (fromAttempts?.version1 == null) null else convertAvailableVarientToDomain(fromAttempts.version1)
    )

    fun convertAvailableVarientToDomain(fromAttempts: AvailableVariants?) = AvailableVariantsEntity(
        if (fromAttempts?.version1 == null) null else convertVersionToDomain(fromAttempts.version1)
    )

    fun convertVersionToDomain(fromAttempts: Version1Data?) = Version1DataEntity(
        fromAttempts?.resourceName,
        fromAttempts?.getPhotos
    )

}