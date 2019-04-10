package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.MainRepository
import com.example.myapplication.domain.entity.ProductsEntity
import javax.inject.Inject

class GetPhotoList @Inject constructor(
    private val mainRepository: MainRepository
) : UseCase<String, List<ProductsEntity>?>() {
    override fun execute(parameters: String): List<ProductsEntity>? {
        val getPhoto = mainRepository.getPhotos(parameters) ?: return null
        return getPhoto
    }

}